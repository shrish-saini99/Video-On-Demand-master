
import com.vmm.JHTTPServer;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyServer extends JHTTPServer {

    String username, password, oldpassword, newpassword;
    String category, coursename, description, sqphoto, widephoto, samplevideo;
    int amount;
    String thumbnail, video;
    String course, title;
    int duration, lectureno;
    String email;

    public MyServer(int port) throws IOException {
        super(port);
    }

    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) {

        Response res = null;
        String ans = "";
        if (uri.contains("/login")) {
            username = parms.getProperty("username");
            password = parms.getProperty("password");
            ResultSet rs = DBLoader.executestatment("select * from admin where username= '" + username + "' and password='" + password + "'");
            try {
                if (rs.next()) {
                    ans = "login successful";
                } else {
                    ans = "incorrect detail";
                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/getresource")) {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            System.out.println(uri);
            res = sendCompleteFile(uri);

        } else if (uri.contains("/changepassword")) {
            username = parms.getProperty("username");
            oldpassword = parms.getProperty("oldpassword");
            newpassword = parms.getProperty("newpassword");
            ResultSet rs = DBLoader.executestatment("select * from admin where username='" + username + "' and password='" + oldpassword + "'");
            try {
                if (rs.next()) {

                    rs.updateString("password", newpassword);
                    rs.updateRow();
                    ans = "password changed";

                } else {
                    ans = "wrong old password";
                }

                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/addcourse")) {
            coursename = parms.getProperty("coursename");
            ResultSet rs = DBLoader.executestatment("select * from courses where course_name='" + coursename + "'");
            try {
                if (rs.next()) {
                    ans = "already exists";
                } else {
                    category = parms.getProperty("category");
                    description = parms.getProperty(("description"));
                    amount = Integer.parseInt(parms.getProperty(("amount")));
                    sqphoto = saveFileOnServerWithRandomName(files, parms, "sqphoto", "src/Pics");
                    widephoto = saveFileOnServerWithRandomName(files, parms, "widephoto", "src/Pics");
                    samplevideo = saveFileOnServerWithRandomName(files, parms, "samplevideo", "src/Videos");
                    System.out.println("category:" + category + " " + sqphoto);
                    rs.moveToInsertRow();
                    rs.updateString("course_name", coursename);
                    rs.updateString("description", description);
                    rs.updateString("category", category);
                    rs.updateInt("amount", amount);
                    rs.updateString("square_photo", "src/Pics/" + sqphoto);
                    rs.updateString("wide_photo", "src/Pics/" + widephoto);

                    rs.updateString("sample_video", "src/Videos/" + samplevideo);
                    rs.insertRow();
                    ans = "row updated";
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            res = new Response(HTTP_OK, "text/plain", ans);
        } else if (uri.contains("/fetchcourses")) {
            category = parms.getProperty("category");
            ResultSet rs = DBLoader.executestatment("select * from courses where category='" + category + "'");
            try {
                while (rs.next()) {
                    coursename = rs.getString("course_name");
                    amount = rs.getInt("amount");
                    description = rs.getString("description");
                    sqphoto=rs.getString("square_photo");
                    ans = ans + coursename + ";" + amount + ";" + description + ";"+sqphoto+"~";

                }
            } catch (Exception ex) {
                ex.printStackTrace();

            }
            res = new Response(HTTP_OK, "text/plain", ans);

        } else if (uri.contains("/deletecourse")) {
            coursename = parms.getProperty("coursename");
            ResultSet rs = DBLoader.executestatment("select * from courses where course_name='" + coursename + "'");
            try {
                if (rs.next()) {
                    rs.deleteRow();
                    ans = "success";
                } else {
                    ans = "fail";
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            res = new Response(HTTP_OK, "text/plain", ans);
        } else if (uri.contains("/fetchcbcourses")) {
            String categories = "";
            category = parms.getProperty("cname");
            // System.out.println(category);
            ResultSet rs = DBLoader.executestatment("select * from courses where category='" + category + "'");
            try {
                while (rs.next()) {
                    String c = rs.getString("course_name");
                    //       System.out.println(c);
                    categories = categories + c + ";";

                }
                ans = categories;
                System.out.println(ans);
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/addvideos")) {
            title = parms.getProperty("title");
            duration = Integer.parseInt(parms.getProperty("duration"));
            lectureno = Integer.parseInt(parms.getProperty("lectureno"));
            category = parms.getProperty("category");
            course = parms.getProperty("course");
            System.out.println(course + " " + lectureno);
            ResultSet rs = DBLoader.executestatment("select * from videos where course_name='" + course + "' and lecture_no='" + lectureno + "'");
            try {
                if (rs.next()) {
                    ans = "already exists";
                } else {
                    thumbnail = saveFileOnServerWithRandomName(files, parms, "thumbnail", "src/Pics");
                    video = saveFileOnServerWithRandomName(files, parms, "video", "src/Videos");
                    rs.moveToInsertRow();
                    rs.updateInt("lecture_no", lectureno);
                    rs.updateInt("duration", duration);
                    rs.updateString("title", title);
                    //  rs.updateString("category_name", category);
                    rs.updateString("course_name", course);
                    rs.updateString("video", "src/Videos/" + video);
                    rs.updateString("video_thumbnail", "src/Pics/" + thumbnail);
                    rs.insertRow();
                    ans = "row inserted";
                }
                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

//            ResultSet rs=DBLoader.executestatment("");
        } else if (uri.contains("/fetchvideos")) {
            ans = "";
            int videoid;
            course = parms.getProperty("course");
            ResultSet rs = DBLoader.executestatment("select * from videos where course_name='" + course + "'");
            try {
                while (rs.next()) {
                    lectureno = rs.getInt("lecture_no");
                    videoid = rs.getInt("video_id");
                    title = rs.getString("title");
                    duration = rs.getInt("duration");
                    String photo=rs.getString("video_thumbnail");
                    ans = ans + lectureno + ";" + videoid + ";" + title + ";" + duration +";"+ photo+"~";
                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else if (uri.equals("/deletevideo")) {
            int videoid = Integer.parseInt(parms.getProperty("videoid"));
            ResultSet rs = DBLoader.executestatment("select * from videos where video_id='" + videoid + "'");
            try {
                if (rs.next()) {
                    rs.deleteRow();
                    ans = "deleted";

                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {

                ex.printStackTrace();
            }

        } else if (uri.contains("/usersignup")) {
            String email, password, phone, name;
            email = parms.getProperty("email");
            password = parms.getProperty("password");
            phone = parms.getProperty("phone");
            name = parms.getProperty("name");

            ResultSet rs = DBLoader.executestatment("select * from users where email='" + email + "'");
            try {
                if (rs.next()) {
                    ans = "already exists";
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("phone", phone);
                    rs.updateString("email", email);
                    rs.updateString("password", password);
                    rs.updateString("name", name);
                    rs.insertRow();
                    ans = "inserted";
                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/userlogin")) {
            email = parms.getProperty("email");
            password = parms.getProperty("password");
            ResultSet rs = DBLoader.executestatment("select * from users where email= '" + email + "' and password='" + password + "'");
            try {
                if (rs.next()) {
                    ans = "login successful";
                } else {
                    ans = "incorrect detail";
                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/userchangepassword")) {
            email = parms.getProperty("email");
            oldpassword = parms.getProperty("oldpassword");
            newpassword = parms.getProperty("newpassword");
            ResultSet rs = DBLoader.executestatment("select * from users where email='" + email + "' and password='" + oldpassword + "'");
            try {
                if (rs.next()) {

                    rs.updateString("password", newpassword);
                    rs.updateRow();
                    ans = "password changed";

                } else {
                    ans = "wrong old password";
                }

                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/fetchsomecategorycourse")) {
            ans = "";
            category = parms.getProperty("category");
            ResultSet rs = DBLoader.executestatment("select * from courses where category='" + category + "'");
            try {
                while (rs.next()) {
                    String course = rs.getString("course_name");
                    String photo = rs.getString("square_photo");
                    int amount = rs.getInt("amount");

                    ans = ans + course + ";" + photo + ";" + amount + "~";
                }
                System.out.println(ans);
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/viewonecourse")) {
            ans = "";
            course = parms.getProperty("course");
            ResultSet rs = DBLoader.executestatment("select * from courses where course_name='" + course + "'");
            try {
                if (rs.next()) {
                    int amount = rs.getInt("amount");
                    String desc = rs.getString("description");
                    String photo = rs.getString("wide_photo");
                    String sphoto = rs.getString("square_photo");
                    ans = amount + ";" + desc + ";" + photo + ";" + sphoto;

                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/getvideos")) {
            String newans = "";
            course = parms.getProperty("course");
            System.out.println("Course is" + course);
            ResultSet rs = DBLoader.executestatment("select * from videos where course_name='" + course + "'");
            try {
                while (rs.next()) {
                    String title = rs.getString("title");
                    int duration = rs.getInt("duration");
                    int lectureno = rs.getInt("lecture_no");
                    String video = rs.getString("video");
                    String photo = rs.getString("video_thumbnail");
                    newans = newans + title + ";" + duration + ";" + lectureno + ";" + photo + ";" + video + "~";

                }
                System.out.println("My ans is" + newans);
                res = new Response(HTTP_OK, "text/plain", newans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/addsubscription")) {
            email = parms.getProperty("email");
            course = parms.getProperty("course");
            ResultSet rs = DBLoader.executestatment("select * from user_subscription where email='" + email + "' and course_name='" + course + "'");
            try {
                if (rs.next()) {
                    ans = "already exists";

                } else {
                    rs.moveToInsertRow();
                    rs.updateString("email", email);
                    rs.updateString("course_name", course);
                    rs.insertRow();
                    ans = "inserted";
                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/checksubscription")) {
            email = parms.getProperty("email");
            course = parms.getProperty("course");
            ResultSet rs = DBLoader.executestatment("select * from user_subscription where course_name='" + course + "' and email='" + email + "'");
            try {
                if (rs.next()) {
                    ans = "payment done";
                } else {
                    ans = "not paid";
                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/getsamplevideo")) {
            String svideo = "";
            String course = parms.getProperty("course");
            ResultSet rs = DBLoader.executestatment("select * from courses where course_name='" + course + "'");
            try {
                if (rs.next()) {
                    svideo = rs.getString("sample_video");
                }
                res = new Response(HTTP_OK, "text/plain", svideo);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/StreamMedia")) {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            System.out.println(uri);
            res = streamFile(uri, method, header);

        }
        else if(uri.contains("/getusername")){
            String email=parms.getProperty("email");
            ResultSet rs=DBLoader.executestatment("select * from users where email='"+email+"'");
            try {
                if(rs.next()){
                    String name=rs.getString("name");
                    ans=name;
                }
                res=new Response(HTTP_OK,"text/plain",ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else {
            res = new Response(HTTP_OK, "text/plain", "hello");
        }
        return res;

        //return super.serve(uri, method, header, parms, files); //To change body of generated methods, choose Tools | Templates.
    }
}
