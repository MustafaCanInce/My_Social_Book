/*
Author: Mustafa Can İnce
Students_ID: 200709081
Date: May 2021
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;





public class MySocialBook {

    public static void main(String[] args) throws IOException{
        int yuh = 0;
        int command_txt_addusers = 0;
        int total_post_number = 0;
        Users[] UsersArray;
        Post[] text;
        ImagePost[] image;
        VideoPost[] video;
        String Still_Signin = "";
        boolean Sigin_check = false;
        int var =0;
        int friend_print = 0;
        int nullver_addfri = 0;
        int blockeduser = 0;
        int totalfriblock_check1 =0;
        int totalfriblock = 0;
        int post_number_text = 0;
        int image_post_number = 0;
        int video_post_number = 0;
        int total_image_number = 0;
        int total_video_number = 0;
        String replace = "";
        int total_friend = 0;
        boolean removetext = false;
        boolean removeimage = false;
        boolean removevideo = false;
        int printing_post_number = 0;
        String friendall= "";
        List<String> usertxt_list = new ArrayList<>();
        List<String> commandstxt_list = new ArrayList<>();

        BufferedReader userstxt_reader = new BufferedReader(new FileReader(args[0]));
        BufferedReader commandstxt_reader = new BufferedReader(new FileReader(args[1]));
        while (true) {
            String paravane = userstxt_reader.readLine();
            if (paravane == null) {
                break;
            }
            usertxt_list.add(paravane);
        }
        userstxt_reader.close();
        while (true) {
            String paravane = commandstxt_reader.readLine();
            if (paravane == null) {
                break;
            }
            commandstxt_list.add(paravane);
        }
        commandstxt_reader.close();
        int size2 = commandstxt_list.size();
        for (int l1 = 0;l1 <= size2;) {
            String yuko = (String) commandstxt_list.get(l1);
            String[] command_txt_index_each_by_each;
            command_txt_index_each_by_each = yuko.split("\t");
            if (command_txt_index_each_by_each[0].equals("ADDUSER")) { //adduser
                command_txt_addusers++;
            }
            if(command_txt_index_each_by_each[0].equals("ADDPOST-TEXT")){
                total_post_number++;
            }
            if(command_txt_index_each_by_each[0].equals("ADDFRIEND")){
                total_friend++;
            }
            if(command_txt_index_each_by_each[0].equals("ADDPOST-IMAGE")){
                total_image_number++;
            }
            if(command_txt_index_each_by_each[0].equals("ADDPOST-VIDEO")){
                total_video_number++;
            }
            l1++;
            if (l1 == commandstxt_list.size())
                break;
        }
        UsersArray = new Users[usertxt_list.size()+command_txt_addusers];
        String[] FriendArray = new String[total_friend-1];       //firiends list  of the logged in user
        String[] blocked = new String[usertxt_list.size()+command_txt_addusers];       //blocked list of the logged in user.
        String[] sum_blocked_users = new String[usertxt_list.size()+command_txt_addusers*(usertxt_list.size()+command_txt_addusers-1)];//all blocked person
        String[] sum_Post = new String[usertxt_list.size()+command_txt_addusers];//tüm postlar
        text = new Post[total_post_number];
        image = new ImagePost[total_image_number];
        video = new VideoPost[total_video_number];

        int l=0;
        while(l <= usertxt_list.size()){
            String sadf = (String) usertxt_list.get(l);        //listedeki indexlere göre ham halini çekiyorum.
            String[] bol;
            bol = sadf.split("\t");
            if(bol.length >= 4) {
                DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                try {
                    Date date = formatter.parse(bol[3]);
                    UsersArray[l] = new Users(l + 1, bol[0], bol[1], bol[2], date, bol[4],"","");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("Yönergeler doğrultusunda veri giriniz.");
                break;
            }
            l++;
            if (l == usertxt_list.size()) {

                break;
            }
        }
        for(int l1 = 0; l1 <=size2 - 1 ; l1++) {
            String yuko = (String) commandstxt_list.get(l1);
            String[] command_txt_index_each_by_each;

            command_txt_index_each_by_each = yuko.split("\t");
            if (command_txt_index_each_by_each[0] != null && command_txt_index_each_by_each.length == 1) {
                System.out.println("Command: " + command_txt_index_each_by_each[0]);
            } else if (command_txt_index_each_by_each[1] != null && command_txt_index_each_by_each.length == 2) {
                System.out.println("Command: " + command_txt_index_each_by_each[0] + "\t" + command_txt_index_each_by_each[1]);
            } else if (command_txt_index_each_by_each[2] != null && command_txt_index_each_by_each.length == 3) {
                System.out.println("Command: " + command_txt_index_each_by_each[0] + "\t" + command_txt_index_each_by_each[1] + "\t" + command_txt_index_each_by_each[2]);
            } else if (command_txt_index_each_by_each[3] != null && command_txt_index_each_by_each.length == 4) {
                System.out.println("Command: " + command_txt_index_each_by_each[0] + "\t" + command_txt_index_each_by_each[1] + "\t" + command_txt_index_each_by_each[2] + "\t" + command_txt_index_each_by_each[3]);
            } else if (command_txt_index_each_by_each[4] != null && command_txt_index_each_by_each.length == 5) {
                System.out.println("Command: " + command_txt_index_each_by_each[0] + "\t" + command_txt_index_each_by_each[1] + "\t" + command_txt_index_each_by_each[2] + "\t" + command_txt_index_each_by_each[3] + "\t" + command_txt_index_each_by_each[4]);
            } else if (command_txt_index_each_by_each[5] != null && command_txt_index_each_by_each.length == 6) {
                System.out.println("Command: " + command_txt_index_each_by_each[0] + "\t" + command_txt_index_each_by_each[1] + "\t" + command_txt_index_each_by_each[2] + "\t" + command_txt_index_each_by_each[3] + "\t" + command_txt_index_each_by_each[4] + "\t" + command_txt_index_each_by_each[5]);
            } else if (command_txt_index_each_by_each[6] != null && command_txt_index_each_by_each.length == 7) {
                System.out.println("Command: " + command_txt_index_each_by_each[0] + "\t" + command_txt_index_each_by_each[1] + "\t" + command_txt_index_each_by_each[2] + "\t" + command_txt_index_each_by_each[3] + "\t" + command_txt_index_each_by_each[4] + "\t" + command_txt_index_each_by_each[5] + "\t" + command_txt_index_each_by_each[6]);
            }
            if (command_txt_index_each_by_each[0].equals("ADDUSER")) {
                command_txt_addusers++;
                DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                try {
                    Date date = formatter.parse(command_txt_index_each_by_each[4]);
                    UsersArray[l] = new Users(l + 1, command_txt_index_each_by_each[1], command_txt_index_each_by_each[2], command_txt_index_each_by_each[3], date, command_txt_index_each_by_each[5],"","");//kişileri ekliyorum.   //command_txt_index_each_by_each[4] date
                    System.out.println(command_txt_index_each_by_each[1] + " has been successfully added." + "\n" + "---------------------------");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                l++;
            }
            if (command_txt_index_each_by_each[0].equals("REMOVEUSER")) {
                for (int i = 0; true; i++) {
                    if (UsersArray[i].getuserID() == Integer.parseInt(command_txt_index_each_by_each[1])) {
                        UsersArray[Integer.parseInt(command_txt_index_each_by_each[1]) - 1] = null;
                        System.out.println("User has been successfully removed." + "\n" + "---------------------------");
                        l++;
                        break;
                    }
                    if (UsersArray.length - 1 == i) {
                        System.out.println("No such user!" + "\n" + "---------------------------");
                        l++;
                        break;
                    }
                }
            }
            yuh = 0;
            while (yuh <= usertxt_list.size() + command_txt_addusers - 1 && command_txt_index_each_by_each[0].equals("SIGNIN")) {
                while (UsersArray[yuh] == null) {
                    yuh++;
                    if (UsersArray[yuh] != null){
                        break;
                    }
                }
                if (command_txt_index_each_by_each[1].equals(UsersArray[yuh].getUsersname())) {
                    if (command_txt_index_each_by_each[2].equals(UsersArray[yuh].getPassword())) {
                        String pattern = "MM-dd-yyyy";
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                        String date = simpleDateFormat.format(new Date());
                        System.out.println("You have successfully signed in." + "\t" + "Users last log in date : " + date + "\n" + "---------------------------");
                        Still_Signin = command_txt_index_each_by_each[1];
                        Sigin_check = true;
                        break;
                    }
                }
                if (UsersArray.length - 1 == yuh) {
                    System.out.println("Invalid username or password! Please try again." + "\n" + "---------------------------");
                    break;
                }
                yuh++;
            }
            if (command_txt_index_each_by_each[0].equals("LISTUSERS")) {
                if(Sigin_check) {
                    for (int deneme = 0; deneme < usertxt_list.size() + command_txt_addusers - 1; deneme++) {
                        if (UsersArray[deneme] == null) {
                            deneme++;
                        }
                        UsersArray[deneme].display();
                    }
                }else {

                    System.out.println("Error: Please sign in and try again." + "\n" + "---------------------------");
                }
            }
            int uptadeprof = 0;
            int nulluptadep = 0;
            if (command_txt_index_each_by_each[0].equals("UPDATEPROFILE")) {
                if (Sigin_check) {
                    while (uptadeprof < usertxt_list.size() + command_txt_addusers - nulluptadep - 1) {
                        if (UsersArray[uptadeprof] == null) {
                            nulluptadep++;
                            uptadeprof++;
                        }
                        if (UsersArray[uptadeprof].getUsers_name().equals(command_txt_index_each_by_each[1]) && Still_Signin.equals(command_txt_index_each_by_each[1].toLowerCase(Locale.ROOT)) && Sigin_check) {
                            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                            try {
                                Date date = formatter.parse(command_txt_index_each_by_each[2]);
                                UsersArray[uptadeprof].setDate_of_birth(date);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            UsersArray[uptadeprof].setSchool_graduated(command_txt_index_each_by_each[3]);
                            System.out.println("Your user profile has been successfully updated" + "\n" + "---------------------------");
                        }
                        if (uptadeprof == usertxt_list.size() + command_txt_addusers - nulluptadep - 1){
                            break;
                        }
                        uptadeprof++;
                    }
                } else {
                    System.out.println("Error: Please sign in and try again." + "\n" + "---------------------------");
                }
            }
            int chpass = 0;
            int nullver = 0;
            if (command_txt_index_each_by_each[0].equals("CHPASS")){
                if (Sigin_check) {
                    while (chpass <= usertxt_list.size() + command_txt_addusers - 1) {
                        if (UsersArray[chpass] == null) {
                            chpass++;
                            nullver++;
                        }
                        if (UsersArray[chpass].getUsersname().equals(Still_Signin) && UsersArray[chpass].getPassword().equals(command_txt_index_each_by_each[1]) && command_txt_index_each_by_each[0].equals("CHPASS")) {
                            UsersArray[chpass].setPassword(command_txt_index_each_by_each[2]);
                            System.out.println("Your Password has been successfully updated" + "\n" + "---------------------------");
                        } else if (UsersArray[chpass].getUsersname().equals(Still_Signin) && !UsersArray[chpass].getPassword().equals(command_txt_index_each_by_each[1])) {
                            System.out.println("Password mismatch!" + "\n" + "---------------------------");
                        }
                        if (chpass == usertxt_list.size() + command_txt_addusers - 2)
                            break;
                        chpass++;
                    }
                }else {
                    System.out.println("Error: Please sign in and try again." + "\n" + "---------------------------");
                }
            }
            int addfrie = 0;
            int users_check = 0;
            int kullanı = 0;
            int kullanı1 = 0;
            if (command_txt_index_each_by_each[0].equals("ADDFRIEND")) {
                if(Sigin_check) {
                    if (addfrie <= usertxt_list.size() + command_txt_addusers - 1) {
                        if (UsersArray[addfrie] == null) {
                            addfrie++;
                            nullver_addfri++;
                        }
                        while (true) {
                            if (UsersArray.length == users_check) {
                                System.out.println("No such user!" + "\n" + "---------------------------");
                                break;
                            }
                            if (UsersArray[users_check] != null && UsersArray[users_check].getUsersname().equals(command_txt_index_each_by_each[1])) {
                                if (FriendArray[var] != null && var != 0 &&( FriendArray[var - 1].equals(command_txt_index_each_by_each[1]) && var >= 1)) {
                                    System.out.println("This user is already in your friend list!" + "\n" + "---------------------------");
                                    break;
                                }
                                FriendArray[var] = command_txt_index_each_by_each[1];
                                var++;
                                friend_print++;
                                System.out.println(command_txt_index_each_by_each[1] + "\t" + "has been successfully added to your friend list." + "\n" + "---------------------------");
                                break;
                            }
                            users_check++;
                        }
                        if (addfrie == usertxt_list.size() + command_txt_addusers - 2)
                            break;
                        addfrie++;
                    }
                }else {
                    System.out.println("Error: Please sign in and try again." + "\n" + "---------------------------");
                }
            }
            int removefri = 0;
            int null_removefri = 0;
            if (command_txt_index_each_by_each[0].equals("REMOVEFRIEND")) {
                if (Sigin_check) {
                    while (removefri <= FriendArray.length) {
                        while (FriendArray[removefri] == null && FriendArray.length-2 >= removefri){
                            removefri++;
                            if (FriendArray[removefri] != null ){
                                break;
                            }
                        }
                        if (command_txt_index_each_by_each[1].equals(FriendArray[removefri])) {
                            FriendArray[removefri] = null;
                            friend_print--;
                            System.out.println(command_txt_index_each_by_each[1] + " has been successfully removed from your friend list." + "\n" + "---------------------------");
                            break;
                        }
                        if (removefri == FriendArray.length - 1) {
                            System.out.println("No such friend!" + "\n" + "---------------------------");
                            break;
                        }
                        removefri++;
                        if (removefri == FriendArray.length) {
                            break;
                        }
                        addfrie++;
                    }
                }else {
                    System.out.println("Error: Please sign in and try again." + "\n" + "---------------------------");
                }
            }
            int deneme = 0;
            int checkv0 =0;
            int check = 0;
            if (command_txt_index_each_by_each[0].equals("LISTFRIENDS")){
                if(Sigin_check) {
                    if (FriendArray == null) {
                        System.out.println("You have not added any friend yet!" + "\n" + "---------------------------");
                        break;
                    }
                    for(int tuyd = 0;UsersArray.length >= tuyd;tuyd++) {
                        while (FriendArray[deneme] == null && FriendArray.length-2 >= deneme) {
                            deneme++;
                            if (FriendArray[deneme] != null ){
                                break;
                            }
                        }
                        if (UsersArray[check] == null && FriendArray[deneme] != null) {
                            check++;
                        }
                        if (FriendArray[deneme] != null && FriendArray[deneme].equals(UsersArray[check].getUsersname())) {
                            UsersArray[check].display();
                            deneme++;
                            check = 0;
                            checkv0++;
                        }
                        if (UsersArray.length == check+1){
                            deneme++;
                            check=0;
                        }
                        if(friend_print == checkv0) {
                            break;
                        }
                        check++;
                    }
                }else {
                    System.out.println("Error: Please sign in and try again." + "\n" + "---------------------------");
                }
            }
            if (command_txt_index_each_by_each[0].equals("ADDPOST-TEXT") || command_txt_index_each_by_each[0].equals("ADDPOST-IMAGE") || command_txt_index_each_by_each[0].equals("ADDPOST-VIDEO")){
                if(Sigin_check){
                    String[] check_kind_of_posrt ;
                    check_kind_of_posrt = command_txt_index_each_by_each[0].split("-");
                    if(check_kind_of_posrt[1].equals("TEXT")){
                        if(FriendArray != null){
                            String[] frie_post_check ;
                            frie_post_check = command_txt_index_each_by_each[4].split(":");
                            int i = 0;
                            int y = 0;
                            if(frie_post_check.length == 1){
                                while (true){
                                    if(FriendArray[i] == null){
                                        i++;
                                    }
                                    if(FriendArray[i].equals(command_txt_index_each_by_each[4])){
                                        double longt = Double.parseDouble(command_txt_index_each_by_each[2]);
                                        double latit = Double.parseDouble(command_txt_index_each_by_each[3]);
                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
                                        LocalDateTime now = LocalDateTime.now();
                                        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                        try {
                                            Date date = formatter.parse(dtf.format(now));
                                            text[post_number_text] = new Post(command_txt_index_each_by_each[1], longt, latit, command_txt_index_each_by_each[4], date);
                                        } catch (ParseException e) {
                                            e.printStackTrace();
                                        }
                                        removeimage =false;
                                        removevideo = false;
                                        removetext = true;
                                        post_number_text++;
                                        printing_post_number++;
                                        System.out.println("The post has been successfully added." + "\n" + "---------------------------");
                                        break;
                                    }
                                    if(FriendArray.length-1 == i){
                                        System.out.println(command_txt_index_each_by_each[4] + " is not your friend, and will not be tagged!");
                                        double longt = Double.parseDouble(command_txt_index_each_by_each[2]);
                                        double latit = Double.parseDouble(command_txt_index_each_by_each[3]);
                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
                                        LocalDateTime now = LocalDateTime.now();
                                        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                        try {
                                            Date date = formatter.parse(dtf.format(now));
                                            text[post_number_text] = new Post(command_txt_index_each_by_each[1], longt, latit, "", date);
                                        } catch (ParseException e) {
                                            e.printStackTrace();
                                        }
                                        printing_post_number++;
                                        removeimage =false;
                                        removevideo = false;
                                        removetext = true;
                                        post_number_text++;
                                        System.out.println("The post has been successfully added.");
                                        break;
                                    }
                                    i++;
                                }
                            }
                            if(frie_post_check.length > 1){
                                for (i = 0; frie_post_check.length >= y; i++){
                                    if(FriendArray[i] == null || FriendArray.length >= i){
                                        i++;
                                    }
                                    if(FriendArray[i] != null && FriendArray[i].equals(frie_post_check[y])){
                                        y++;
                                        i = 0;
                                    }
                                    if(FriendArray.length-1 == i && y != frie_post_check.length){
                                        if (y == 0){
                                            replace = frie_post_check[y] + ":";
                                            command_txt_index_each_by_each[4] = command_txt_index_each_by_each[4].replaceFirst(replace, ":");
                                        }
                                        if (y > 0){
                                            replace = ":" + frie_post_check[y];
                                            command_txt_index_each_by_each[4] = command_txt_index_each_by_each[4].replaceFirst(replace, ":");
                                        }
                                        System.out.println(frie_post_check[y] + " is not your friend, and will not be tagged!");
                                        i = 0;
                                        y++;
                                    }
                                    if(frie_post_check.length == y){
                                        double longt = Double.parseDouble(command_txt_index_each_by_each[2]);
                                        double latit = Double.parseDouble(command_txt_index_each_by_each[3]);
                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
                                        LocalDateTime now = LocalDateTime.now();
                                        System.out.println("The post has been successfully added." + "\n" + "---------------------------");
                                        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                        try {
                                            Date date = formatter.parse(dtf.format(now));
                                            text[post_number_text] = new Post(command_txt_index_each_by_each[1], longt, latit, command_txt_index_each_by_each[4], date);
                                        } catch (ParseException e) {
                                            e.printStackTrace();
                                        }
                                        printing_post_number++;
                                        removeimage =false;
                                        removevideo = false;
                                        removetext = true;
                                        post_number_text++;
                                        break;
                                    }
                                }
                            }
                        }else if (FriendArray == null) {
                            System.out.println("Your friends list is empty!");
                            break;
                        }
                    }
                    if(check_kind_of_posrt[1].equals("IMAGE")){
                        if (FriendArray != null ) {
                            String[] frie_post_check ;
                            frie_post_check = command_txt_index_each_by_each[4].split(":");
                            int i = 0;
                            int y = 0;
                            if(frie_post_check.length == 1){
                                while (true){
                                    if(FriendArray[i] == null){
                                        i++;
                                    }
                                    if(FriendArray.length-3 == i){
                                        System.out.println(command_txt_index_each_by_each[4] + " is not your friend, and will not be tagged!");
                                        double longt = Double.parseDouble(command_txt_index_each_by_each[2]);
                                        double latit = Double.parseDouble(command_txt_index_each_by_each[3]);
                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
                                        LocalDateTime now = LocalDateTime.now();
                                        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                        try {
                                            Date date = formatter.parse(dtf.format(now));
                                            image[image_post_number] = new ImagePost(command_txt_index_each_by_each[1], longt, latit, "", command_txt_index_each_by_each[5], command_txt_index_each_by_each[6], date);
                                        } catch (ParseException e) {
                                            e.printStackTrace();
                                        }
                                        printing_post_number++;
                                        removetext =false;
                                        removevideo = false;
                                        removeimage = true;
                                        image_post_number++;
                                        System.out.println("The post has been successfully added." + "\n" + "---------------------------");
                                        break;
                                    }
                                    if(FriendArray[i].equals(command_txt_index_each_by_each[4]) && FriendArray[i] != null){
                                        double longt = Double.parseDouble(command_txt_index_each_by_each[2]);
                                        double latit = Double.parseDouble(command_txt_index_each_by_each[3]);
                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
                                        LocalDateTime now = LocalDateTime.now();
                                        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                        try {
                                            Date date = formatter.parse(dtf.format(now));
                                            image[image_post_number] = new ImagePost(command_txt_index_each_by_each[1], longt, latit, command_txt_index_each_by_each[4], command_txt_index_each_by_each[5], command_txt_index_each_by_each[6], date);
                                        } catch (ParseException e) {
                                            e.printStackTrace();
                                        }

                                        printing_post_number++;
                                        removetext =false;
                                        removevideo = false;
                                        removeimage = true;
                                        image_post_number++;
                                        System.out.println("The post has been successfully added." + "\n" + "---------------------------");
                                        break;
                                    }
                                    i++;
                                }
                            }
                            if(frie_post_check.length > 1){
                                for (i = 0; frie_post_check.length >= y; i++){
                                    if(FriendArray[i] == null || FriendArray.length >= i){
                                        i++;
                                    }
                                    if(FriendArray[i] != null && FriendArray[i].equals(frie_post_check[y])){
                                        y++;
                                        i = 0;
                                    }
                                    if(FriendArray.length-1 == i && y != frie_post_check.length) {            //y 0 sa farklı y 0 dan büyükse farklı kod çalışacak.
                                        if (y == 0){
                                            replace = frie_post_check[y] + ":";
                                            command_txt_index_each_by_each[4] = command_txt_index_each_by_each[4].replaceFirst(replace, ":");
                                        }
                                        if (y > 0){
                                            replace = ":" + frie_post_check[y];
                                            command_txt_index_each_by_each[4] = command_txt_index_each_by_each[4].replaceFirst(replace, ":");
                                        }
                                        System.out.println(frie_post_check[y] + " is not your friend, and will not be tagged!");
                                        i = 0;
                                        y++;
                                    }
                                    if(frie_post_check.length == y){
                                        double longt = Double.parseDouble(command_txt_index_each_by_each[2]);
                                        double latit = Double.parseDouble(command_txt_index_each_by_each[3]);

                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
                                        LocalDateTime now = LocalDateTime.now();
                                        System.out.println("The post has been successfully added." + "\n" + "---------------------------");
                                        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                        try {
                                            Date date = formatter.parse(dtf.format(now));
                                            image[image_post_number] = new ImagePost(command_txt_index_each_by_each[1], longt, latit, command_txt_index_each_by_each[4], command_txt_index_each_by_each[5], command_txt_index_each_by_each[6], date);
                                        } catch (ParseException e) {
                                            e.printStackTrace();
                                        }
                                        printing_post_number++;
                                        removetext = false;
                                        removevideo = false;
                                        removeimage = true;
                                        image_post_number++;
                                        break;
                                    }
                                }
                            }
                        }else if (FriendArray == null) {
                            System.out.println("Your friends list is empty!");
                            break;
                        }
                    }
                    if(check_kind_of_posrt[1].equals("VIDEO")){
                        if (FriendArray != null ) {
                            String[] frie_post_check ;
                            frie_post_check = command_txt_index_each_by_each[4].split(":");
                            int i = 0;
                            int y = 0;
                            int x = 0;
                            if(frie_post_check.length == 1){
                                while (true){
                                    if (Integer.parseInt(command_txt_index_each_by_each[6]) > 10 || Integer.parseInt(command_txt_index_each_by_each[6]) < 0){
                                        System.out.println("The video length is incorrect (accepted length is between 0 and 10)!!" + "\n" + "---------------------------");
                                        break;
                                    }
                                    if(FriendArray[i] == null){
                                        i++;
                                    }
                                    if(FriendArray[i].equals(command_txt_index_each_by_each[4]) && (Integer.parseInt(command_txt_index_each_by_each[6]) < 10 || Integer.parseInt(command_txt_index_each_by_each[6]) > 0)){
                                        double longt = Double.parseDouble(command_txt_index_each_by_each[2]);
                                        double latit = Double.parseDouble(command_txt_index_each_by_each[3]);
                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
                                        LocalDateTime now = LocalDateTime.now();
                                        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                        try {
                                            Date date = formatter.parse(dtf.format(now));
                                            video[video_post_number] = new VideoPost(command_txt_index_each_by_each[1], longt, latit,"", command_txt_index_each_by_each[5],Integer.parseInt(command_txt_index_each_by_each[6]),date);
                                        } catch (ParseException e) {
                                            e.printStackTrace();
                                        }
                                        printing_post_number++;
                                        video_post_number++;
                                        removetext=false;
                                        removeimage=false;
                                        removevideo = true;
                                        System.out.println("The post has been successfully added." + "\n" + "---------------------------");
                                        break;
                                    }
                                    if(FriendArray.length-1 == i && (Integer.parseInt(command_txt_index_each_by_each[6]) < 10 && Integer.parseInt(command_txt_index_each_by_each[6]) > 0)){
                                        x = y;
                                        System.out.println(command_txt_index_each_by_each[4] + " is not your friend, and will not be tagged!");
                                        double longt = Double.parseDouble(command_txt_index_each_by_each[2]);
                                        double latit = Double.parseDouble(command_txt_index_each_by_each[3]);
                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
                                        LocalDateTime now = LocalDateTime.now();
                                        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                        try {
                                            Date date = formatter.parse(dtf.format(now));
                                            video[video_post_number] = new VideoPost(command_txt_index_each_by_each[1], longt, latit,command_txt_index_each_by_each[4], command_txt_index_each_by_each[5],Integer.parseInt(command_txt_index_each_by_each[6]),date);
                                        } catch (ParseException e) {
                                            e.printStackTrace();
                                        }
                                        printing_post_number++;
                                        removetext=false;
                                        removeimage=false;
                                        removevideo = true;
                                        video_post_number++;
                                        System.out.println("The post has been successfully added." );
                                        break;
                                    }
                                    i++;
                                }
                            }
                            if(frie_post_check.length > 1){
                                for (i = 0; frie_post_check.length >= y; ){
                                    if (Integer.parseInt(command_txt_index_each_by_each[6]) > 10 || Integer.parseInt(command_txt_index_each_by_each[6]) < 0){
                                        System.out.println("The video length is incorrect (accepted length is between 0 and 10)!!" + "\n" + "---------------------------");
                                        break;
                                    }
                                    if(FriendArray[i] == null || FriendArray.length >= i){
                                        i++;
                                    }
                                    if(FriendArray[i] != null && FriendArray[i].equals(frie_post_check[y])){
                                        y++;
                                        i = 0;
                                    }
                                    if(FriendArray.length-1 == i && y != frie_post_check.length){//
                                        if (y == 0){
                                            replace = frie_post_check[y] + ":";
                                            command_txt_index_each_by_each[4] = command_txt_index_each_by_each[4].replaceFirst(replace, ":");
                                        }
                                        if (y > 0){
                                            replace = ":" + frie_post_check[y];
                                            command_txt_index_each_by_each[4] = command_txt_index_each_by_each[4].replaceFirst(replace, ":");
                                        }
                                        System.out.println(frie_post_check[y] + " is not your friend, and will not be tagged!");
                                        i = 0;
                                        y++;
                                    }
                                    if(y == frie_post_check.length && (Integer.parseInt(command_txt_index_each_by_each[6]) < 10 || Integer.parseInt(command_txt_index_each_by_each[6]) > 0)){
                                        replace =frie_post_check[x];
                                        double longt = Double.parseDouble(command_txt_index_each_by_each[2]);
                                        double latit = Double.parseDouble(command_txt_index_each_by_each[3]);
                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
                                        LocalDateTime now = LocalDateTime.now();
                                        printing_post_number++;
                                        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                        try {
                                            Date date = formatter.parse(dtf.format(now));
                                            video[video_post_number] = new VideoPost(command_txt_index_each_by_each[1], longt, latit,command_txt_index_each_by_each[4], command_txt_index_each_by_each[5],Integer.parseInt(command_txt_index_each_by_each[6]),date);
                                        } catch (ParseException e) {
                                            e.printStackTrace();
                                        }
                                        removetext=false;
                                        removeimage=false;
                                        removevideo = true;
                                        video_post_number++;
                                        System.out.println("The post has been successfully added." + "\n" + "---------------------------");
                                        break;
                                    }
                                }
                            }

                        }else if (FriendArray == null) {
                            System.out.println("Your friends list is empty!");      //empty olsa bile eklenmesi lazım.
                            break;
                        }
                    }
                }else {
                    System.out.println("Error: Please sign in and try again." + "\n" + "---------------------------");
                }
            }
            boolean denem3 = false;
            boolean denem2 = false;
            boolean denem1 = false;
            if (command_txt_index_each_by_each[0].equals("REMOVELASTPOST")){
                if(Sigin_check){
                    if(text != null || video != null || image != null){     //anlamsız.

                        if (true){
                            for (int i = 0; text[i] == null; i++){
                                if (text.length -1 ==i){
                                    denem3 = true;
                                    break;
                                }
                            }
                            for (int i = 0; image[i] == null; i++){
                                if (image.length -1 ==i){
                                    denem2 = true;
                                    break;
                                }
                            }
                            for (int i = 0; video[i] == null; i++){
                                if (video.length -1 ==i){
                                    denem1 = true;
                                    break;
                                }
                            }
                        }

                        if (denem1 && denem2 && denem3) {
                            System.out.println("Error: You do not have any post." + "\n" + "---------------------------");
                        }
                        while(!denem1 && !denem2 && !denem3) {

                            if (removetext) {
                                int removepost1 = text.length - 1;
                                text[removepost1] = null;
                                System.out.println("Your last post has been successfully removed." + "\n" + "---------------------------");
                                printing_post_number--;
                                removetext = false;
                                break;
                            }
                            if (removeimage) {
                                int removepost1 = image.length - 1;
                                image[removepost1] = null;
                                printing_post_number--;
                                System.out.println("Your last post has been successfully removed." + "\n" + "---------------------------");
                                removeimage = false;
                                break;
                            }
                            if (removevideo) {
                                int removepost1 = video.length - 1;
                                video[removepost1] = null;
                                printing_post_number--;
                                System.out.println("Your last post has been successfully removed." + "\n" + "---------------------------");
                                removevideo = false;
                                break;
                            }
                        }
                    }
                    else{
                        System.out.println("Error: You do not have any post." + "\n" + "---------------------------");
                        break;
                    }
                }else {
                    System.out.println("Error: Please sign in and try again." + "\n" + "---------------------------");
                }
            }
            int printing_text = 0;
            int printing_image = 0;
            int printing_video = 0;
            int showpostbreaker = 0;
            int show =0;
            if (command_txt_index_each_by_each[0].equals("SHOWPOSTS")){
                if(Sigin_check){
                    if(text != null || image != null || video != null){     //yanlış
                        if (true){
                            for (int i = 0; text[i] == null; i++){
                                if (text.length -1 ==i){
                                    denem3 = true;
                                    break;
                                }
                            }
                            for (int i = 0; image[i] == null; i++){
                                if (image.length -1 ==i){
                                    denem2 = true;
                                    break;
                                }
                            }
                            for (int i = 0; video[i] == null; i++){
                                if (video.length -1 ==i){
                                    denem1 = true;
                                    break;
                                }
                            }
                        }

                        while (!denem1 && !denem2 && !denem3){
                            if (show ==0){
                                System.out.println("**************" + "\n" + command_txt_index_each_by_each[1] + "’s Posts" + "\n" + "**************");
                            }
                            show++;
                            if (printing_text <= text.length - 1){
                                if(text[printing_text] == null){
                                    printing_text++;
                                }else {
                                    System.out.println(text[printing_text].getText() + "\n" + "Date: " + new SimpleDateFormat("MM-dd-yyyy").format(text[printing_text].getDate()) + "\n" + "Location: " + text[printing_text].getLongtiue() + ", " + text[printing_text].getLatitue() + "\n" + "Friends tagged in this post: " + text[printing_text].getTaggedFriend() + "\n" + "---------------------------");
                                    showpostbreaker++;
                                }
                                printing_text++;
                            }
                            else if (printing_image <= image.length - 1) {
                                if(image[printing_image] == null){
                                    printing_image++;
                                }
                                else {
                                    System.out.println(image[printing_image].getText() + "\n" + "Date: " + new SimpleDateFormat("MM-dd-yyyy").format(image[printing_image].getDate()) + "\n" + "Location: " + image[printing_image].getLongtiue() + ", " + image[printing_image].getLatitue() + "\n" + "Friends tagged in this post: " + image[printing_image].getTaggedFriend() + "\n" + "Image: " + image[printing_image].getImageName() + "\n" + "Image resolution: " + image[printing_image].getImageResulation() + "\n" + "---------------------------");
                                    showpostbreaker++;
                                }
                                printing_image++;

                            }
                            else if (printing_video <= video.length - 1) {
                                if(video[printing_video] == null){
                                    printing_video++;
                                }
                                else {
                                    System.out.println(video[printing_video].getText() + "\n" + "Date: " + new SimpleDateFormat("MM-dd-yyyy").format(video[printing_video].getDate()) + "\n" + "Location: " + video[printing_video].getLongtiue() + ", " + video[printing_video].getLatitue() + "\n" + "Friends tagged in this post: " + video[printing_video].getTaggedFriend() + "\n" + "Video: " + video[printing_video].getVideoName() + "\n" + "Video duration: " + video[printing_video].getVideoDuration() + "\n" + "---------------------------");
                                    showpostbreaker++;
                                }
                                printing_video++;
                            }
                            if(printing_post_number == showpostbreaker){
                                break;
                            }
                        }
                    }
                    if(denem1 && denem2 && denem3){
                        System.out.println(command_txt_index_each_by_each[1] + " does not have any posts yet." + "\n" + "---------------------------");
                    }
                }else {
                    System.out.println("Error: Please sign in and try again." + "\n" + "---------------------------");
                }
            }
            int usershul = 0;
            int blockloop = 0;
            if (command_txt_index_each_by_each[0].equals("BLOCK")) {
                if (Sigin_check) {
                    while (blockloop <= usertxt_list.size() + command_txt_addusers - 2) {
                        if (UsersArray[usershul] == null) {
                            usershul++;
                        }
                        if (UsersArray[usershul].getUsersname().equals(command_txt_index_each_by_each[1])) {
                            if (blockeduser != 0 && blocked[blockeduser - 1].equals(command_txt_index_each_by_each[1])) {
                                System.out.println("This user is already blocked!" + "\n" + "---------------------------");
                                break;
                            }
                            blocked[blockeduser] = command_txt_index_each_by_each[1];
                            totalfriblock_check1++;
                            blockeduser++;
                            blockloop++;
                            System.out.println(command_txt_index_each_by_each[1] + "\t" + "has been successfully blocked." + "\n" + "---------------------------");
                            totalfriblock++;
                            break;
                        }
                        if (UsersArray.length - 1 == usershul) {
                            System.out.println("No such user!" + "\n" + "---------------------------");
                            break;
                        }
                        if (blockloop == usertxt_list.size() + command_txt_addusers - 2) {
                            System.out.println("No such user!" + "\n" + "---------------------------");
                            break;
                        }
                        blockloop++;
                        usershul++;
                    }
                }else {
                    System.out.println("Error: Please sign in and try again." + "\n" + "---------------------------");
                }
            }
            int arrcheck = 0;
            int blockcheck = 0;
            int friendarrayindex = 0;
            boolean loopbraeker2 = true;
            int loopbraeker = 0;
            if (command_txt_index_each_by_each[0].equals("SHOWBLOCKEDFRIENDS")){
                if(Sigin_check){
                    for (int i = 0; FriendArray[i] == null || blocked[i] == null; i++) {
                        if (FriendArray.length - 1 == i) {
                            System.out.println("You have not added any friend yet! or block" + "\n" + "---------------------------");
                            loopbraeker2 = false;
                            break;
                        }
                    }
                    {
                        while (FriendArray.length-1 >= friendarrayindex && loopbraeker2){
                            if(blocked.length == blockcheck){
                                friendarrayindex++;
                                blockcheck = 0;
                            }
                            if (FriendArray[friendarrayindex] == null){
                                friendarrayindex++;
                            }
                            if (blocked[blockcheck] == null){
                                blockcheck++;
                            }
                            if (UsersArray[arrcheck] == null){
                                arrcheck++;
                            }
                            while (FriendArray[friendarrayindex].equals(blocked[blockcheck])){
                                if (UsersArray[arrcheck].getUsersname().equals(FriendArray[friendarrayindex])){
                                    loopbraeker++;
                                    UsersArray[arrcheck].display();
                                    friendarrayindex ++;
                                }
                                if (UsersArray[arrcheck] == null){
                                    arrcheck++;
                                }
                                arrcheck++;
                            }
                            if (totalfriblock_check1 == loopbraeker+1){
                                break;
                            }
                            blockcheck++;
                        }
                    }
                }else {
                    System.out.println("Error: Please sign in and try again." + "\n" + "---------------------------");
                }
            }
            int noblockuser = 0;
            int unblock_try = 0;
            if (command_txt_index_each_by_each[0].equals("UNBLOCK")){
                if(Sigin_check){
                    while (true){
                        if(command_txt_index_each_by_each[1].equals(blocked[unblock_try])){
                            blocked[unblock_try] = null;
                            totalfriblock_check1--;
                            System.out.println(command_txt_index_each_by_each[1]+" has been successfully unblocked." + "\n" + "---------------------------");
                            break;
                        }else if (blocked[noblockuser] == null){
                            System.out.println("No such user!" + "\n" + "---------------------------");
                            break;
                        }
                        noblockuser++;
                        unblock_try++;
                    }
                }else {
                    System.out.println("Error: Please sign in and try again." + "\n" + "---------------------------");
                }
            }

            int all_block = 0;
            int arrcheckv_blocked = 0;
            boolean nullortrue = true;
            if (command_txt_index_each_by_each[0].equals("SHOWBLOCKEDUSERS")){
                if(Sigin_check){
                    for (int i = 0; FriendArray[i] == null && blocked[i] == null; i++) {
                        if (FriendArray.length - 1 == i) {
                            System.out.println("You have not added any friend yet! or block" + "\n" + "---------------------------");
                            nullortrue = false;
                            break;
                        }
                    }
                    if(blocked == null){
                        System.out.println("You haven’t blocked any user yet!" + "\n" + "---------------------------");
                    }

                    while (nullortrue) {
                        if(blocked[all_block] == null){
                            all_block++;
                        }
                        if(UsersArray[arrcheckv_blocked] == null){
                            arrcheckv_blocked++;
                        }
                        {
                            if (blocked[all_block].equals(UsersArray[arrcheckv_blocked].getUsersname())){
                                all_block++;
                                UsersArray[arrcheckv_blocked].display();
                                break;
                            }
                        }
                        arrcheckv_blocked++;
                        if(1 == all_block){
                            break;
                        }
                    }
                }else{
                    System.out.println("Error: Please sign in and try again." + "\n" + "---------------------------");
                }
            }
            if (command_txt_index_each_by_each[0].equals("SIGNOUT")){
                for (int i = 0; FriendArray.length - 1 >= i; i++){
                    FriendArray[i]=null;
                }
                Sigin_check =false;
                System.out.println("You have successfully signed out." + "\n" + "---------------------------");
            }
        }
    }
}


class Post extends Location {
    private String Text;             //must
    private String TaggedFriend;     //must
    private Date Date;               //must

    public Post(String Text, double longtiue, double latitue ,String TaggedFriend, Date Date){ //
        this.Text = Text;
        this.setLongtiue(longtiue);
        this.setLatitue(latitue);
        this.TaggedFriend = TaggedFriend;
        this.Date = Date;
    }
    //setter
    protected void setText(String Text){
        this.Text = Text;
    }
    protected void setTaggedFriend(String TaggedFriend){
        this.TaggedFriend = TaggedFriend;
    }
    protected void setDate(Date Date){
        this.Date = Date;
    }
    //getter
    protected String getText (){
        return Text;
    }
    protected String getTaggedFriend(){
        return TaggedFriend;
    }
    protected Date getDate(){
        return Date;
    }
}


class Location {
    private double longtiue;
    private double latitue ;
    //setter
    protected void setLongtiue(double longtiue){
        this.longtiue = longtiue;
    }
    protected void setLatitue(double latitue){
        this.latitue = latitue;
    }
    //getter
    protected double getLongtiue(){
        return longtiue;
    }
    protected double getLatitue(){
        return latitue;
    }
}


class ImagePost extends Location{
    private String Text;             //must
    private String TaggedFriend;     //must
    private Date Date;
    private String ImageName;
    private String ImageResulation;


    public ImagePost(String Text, double longtiue, double latitue, String TaggedFriend, String ImageName, String ImageResulation, Date Date){
        this.Text = Text;
        this.setLongtiue(longtiue);
        this.setLatitue(latitue);
        this.TaggedFriend = TaggedFriend;
        this.ImageName = ImageName;
        this.ImageResulation = ImageResulation;
        this.Date = Date;
    }
    //setter
    protected void setText(String Text){
        this.Text = Text;
    }
    protected void setTaggedFriend(String TaggedFriend){
        this.TaggedFriend = TaggedFriend;
    }
    protected void setDate(Date Date){
        this.Date = Date;
    }
    protected void setImageName(String ImageName){
        this.ImageName = ImageName;
    }
    protected void setImageResulation(String ImageResulation){
        this.ImageResulation = ImageResulation;
    }
    //getter
    protected String getText(){
        return Text;
    }
    protected String getTaggedFriend(){
        return TaggedFriend;
    }
    protected Date getDate(){
        return Date;
    }
    protected String getImageName(){
        return ImageName;
    }
    protected String getImageResulation(){
        return ImageResulation;
    }
}


class VideoPost extends Location{
    private String Text;             //must
    private String TaggedFriend;     //must
    private Date Date;
    private String VideoName;
    private int VideoDuration;

    public VideoPost(String Text, double longtiue, double latitue,String TaggedFriend, String VideoName, int VideoDuration, Date Date){
        this.Text = Text;
        this.setLongtiue(longtiue);
        this.setLatitue(latitue);
        this.TaggedFriend = TaggedFriend;
        this.VideoName = VideoName;
        this.VideoDuration = VideoDuration;
        this.Date = Date;
    }
    //setter
    protected void setText(String Text){
        this.Text = Text;
    }
    protected void setTaggedFriend(String TaggedFriend){
        this.TaggedFriend = TaggedFriend;
    }
    protected void setDate(Date Date){
        this.Date = Date;
    }
    protected void setVideoName(String VideoName){
        this.VideoName = VideoName;
    }
    protected void setVideoDuration(int VideoDuration){
        this.VideoDuration = VideoDuration;
    }
    //getter
    protected String getText (){
        return Text;
    }
    protected String getTaggedFriend (){
        return TaggedFriend;
    }
    protected Date getDate (){
        return Date;
    }
    protected String getVideoName (){
        return VideoName;
    }
    protected int getVideoDuration (){
        return VideoDuration;
    }

}


class Users {


    private String Users_name;
    private Date Date_of_birth;   //new SimpleDateFormat("MM-dd-yyyy").format(date)
    private String School_graduated;
    private String Usersname;   //unique
    private String Password;    //unique
    private int userID;           //unique start from 1
    private String collection_of_friends ;
    private String collection_of_blocked  ;

    protected Users(int id,String name ,String nick , String passw, Date birth,String school,String friends,String blocked) {
        this.userID = id;
        this.Users_name = name;
        this.School_graduated = school;
        this.Usersname = nick;
        this.Password = passw;
        this.Date_of_birth = birth;
        this.collection_of_blocked =friends;
        this.collection_of_friends = blocked;
    }
    //setter
    protected void setUsers_name(String name){
        this.Users_name = name;
    }
    protected void setUsersname(String nick){
        this.Usersname = nick;
    }
    protected void setPassword(String passw){
        this.Password = passw;
    }
    protected void setDate_of_birth(Date birth){
        this.Date_of_birth = birth;
    }
    protected void setSchool_graduated(String school){
        this.School_graduated = school;
    }
    protected void setuserID(int id){
        this.userID = id;
    }
    protected  void setCollection_of_friends(String friends){
        this.collection_of_friends=friends;
    }
    protected void setCollection_of_blocked(String blocked){
        this.collection_of_blocked = blocked;
    }
    //getter
    protected String getUsers_name(){
        return Users_name;
    }
    protected String getUsersname(){
        return Usersname;
    }
    protected String getPassword(){
        return Password;
    }
    protected Date getDate_of_birth(){
        return Date_of_birth;
    }
    protected String getSchool_graduated(){
        return School_graduated;
    }
    protected int getuserID(){
        return userID;
    }
    protected String getCollection_of_friends(){
        return collection_of_friends;
    }
    protected String getCollection_of_blocked(){
        return  collection_of_blocked;
    }

    protected void display(){
        System.out.println("Name:" + "\t" + Users_name + "\n" + "Username:" + "\t" + Usersname + "\n" + "Date of Birth:" + "\t" + new SimpleDateFormat("MM-dd-yyyy").format(Date_of_birth) + "\n" + "School:" + "\t"+School_graduated + "\n" + "---------------------------");// userID+"\t"+      +Password+"\t"
    }
}

