# CENG 1004: Introduction to Object Oriented Programming Spring 2021

## MIDTERM ASSIGNMENT

### 1 Overview of the Application

In this assignment, you will develop your social media platform (what we will call it is
mysocialbook) with very simplified use case
scenarios. To complete every functionality
of mysocialbook, please read each of the following lines with a high care.
### 2 Application’s Specification

This and the following sections are dedicated
to clearly review the requirements (or specification) of the system you are going to develop.
The core components of the system will include:

• users (people having an account of mysocialbook),

• posts (textual or multimedia post shared by users).

You will be given two files separately: the one contains information necessary for creating the
initial users for the system, while the other contains different commands to test various use
case scenarios of your application.
These components are further explained in detail in the following sections.

#### 2.1 Users
Users refers to the people who only use mysocialbook platform (i.e., they do not have any
privilege such as admin, system manager, and the like). The properties and behaviors that
user can have are listed below:

• Every User in the system has a unique userID, a name, a unique username, a password, a date of birth, information about school from which the user graduated,
a last log-in date, a collection of friends, a collection of blocked users, and a
collection of posts.

• userIDs should be assigned as integers in order, starting from 1 for the first user that
is added to the system. These IDs cannot be changed later. A newly added user
should never get an ID that has been assigned before to some other user, even
in cases when other users get removed from the system.

• Users’ dates of birth and last log-in dates should be stored as Date variables.

• Users must perform

– Sign in,
– Sign out,
– Update their user profile info (name, date of birth, and school graduated),
– Change their passwords,
– Add friends to their friend lists,
– Remove friends from their friend lists,
– Add posts,
– Remove posts,
– Block users,
– Unblock users,
– List their friends,
– List all users,
– List blocked friends,
– List blocked users.

• It is a must for any user to be logged-in in order for her/him to perform any of
these actions other than sign in.

• You are required to hide sensitive personal user info and implement setter and getter
methods as necessary.

• mysocialbook platform should begin execution by reading a tab-separated file named
users.txt. The user’s data will be given as following format:

name<TAB>username<TAB>password<TAB>dateofBirth<TAB>graduatedSchool
An exemplar for the content of this file is shown below:
Ahmet ahmet ahmet123 04/25/2001 Meram Anadolu Lisesi
Demet demet demet00 01/16/1999 Ankara Fen Lisesi
Zeki zeki zeki01 08/16/1987 Kadıkoy Lisesi
Gizem gizem gizem1 12/09/1997 Hacettepe ¨Universitesi
Utku utku utku99 10/06/1999 Bilkent ¨Universitesi
Hakan hakan hakan81 03/01/1981 Mugla S.K. ¨Universitesi

#### 2.2 Posts
They can either be a textual or multimedia content shared by users. You are expected to
design your post classes in a hierarchical structure. The necessary information about posts is
as follows:

• Posts are categorized as either text posts, image posts, or video posts. But be careful:
these posts have a textual part in common, and can optionally contain image or
video (for image and video post categories, respectively!).

• mysocialbook should be designed such that it is open for an integration of any new
post type (e.g., hypertext posts) that may or may not have a textual part.
• Every post category must contain a location, a collection of tagged friends, and a
date when the post originated.

• Location should be implemented as a separate class with the following attributes:
latitude and longitude (stored as double values).

• The format to display the post itself can change with respect to the post type
of interest. So, in the case of inclusion a new post type to mysocialbook, designer must
specify its printing format. You should enforce user who proposes a new post type to
implement display format of that post.

• Text posts have a text.

• Image posts have the image filename, and the image resolution (width and height
in pixels).

• Video posts have the video filename, video duration, and a constant attribute
that specifies the maximum video length in minutes (the maximum allowed video
duration is 10 minutes).

• Note that you are required to implement setter and getter methods as necessary.

### 3 Testing Scenarios

i. Add New User: The system should also be open for adding new users. The program
should add a if the syntax of the command is as provided below:

ADDUSER<TAB>name<TAB>userName<TAB>password<TAB>dateofBirth<TAB>schoolGraduated
Illustration of execution:
ADDUSER Adnan adnan adnan1 01/01/1991 Selcuk Universitesi
Adnan has been successfully added.

ii. Remove Existing User: The system should also remove an existing user It takes one
parameter which indicates userID.
REMOVEUSER<TAB>userID
Illustration of execution:
REMOVEUSER 1
User has been successfully removed.
No such user!

iii. Show Posts: 
The system should also be able to display users’ posts. The parameter for
this action is a username.
SHOWPOSTS<TAB>userName
Illustration of execution:
```
SHOWPOSTS userName
adnan does not have any posts yet.
No such user!
--
adnan’s Posts
--
1st text post
Date: 04/14/2017
Location: 39.88, 32.73
———————-
1st text post
Date: 04/14/2017
Location: 39.88, 32.73
Friends tagged in this post: Ahmet, Demet, Adnan
———————-
1st image post
Date: 04/14/2017
Location: 42.88, 32.63
Friends tagged in this post: Demet, Gizem
Image: image.png
Image resolution: 135x250
———————-
1st video post
Date: 04/14/2017
Location: 39.88, 32.63
Friends tagged in this post: Utku
Video: myvideo.avi
Video duration: 8.0 minutes
———————-
```
iv. Sign-In: This is the base action for users to perform before they are allowed to interact
with the system and execute other commands. As in a real application, this evaluator
takes two parameters that are a username and a password.
SIGNIN<TAB>userName<TAB>password
Illustration of execution:
SIGNIN adnan adnan1
You have successfully signed in.
Invalid username or password! Please try again.
v. Sign-Out: It prevents the user from executing any scenarios other than sign-in. No
argument needed to perform this command since it is assumed only one user can log in
to the system at a particular time.
SIGNOUT
Illustration of execution:
SIGNOUT
You have successfully signed out.
vi. Update Profile: User who has already logged in may change his/her personal information (name, date of birth, and school from which (s)he graduated). It takes three
arguments and these are assumed to be the updated values.
UPDATEPROFILE<TAB>name<TAB>dateofBirth<TAB>schoolGraduated
Illustration of execution:
UPDATEPROFILE Adnan 07/01/1991 Mugla S.K. Universitesi ¨
Your user profile has been successfully updated
Error: Please sign in and try again.
vii. Change Password: A user may want to change his/her password. The system should
first check if the provided password matches the current password.
CHPASS<TAB>oldPassword<TAB>newPassword
Illustration of execution:
CHPASS adnan1 adnan123
Password mismatch!
Error: Please sign in and try again.
viii. Add New Friend: Friendship is the most important point in mysocialbook and without
which probably it would not gain much attention. The system you will develop should
allow a user who has signed in to add an existing user as a friend. It takes only one
argument, which indicates user name of the user who will be added.
ADDFRIEND<TAB>userName
Illustration of execution:
ADDFRIEND ahmet
ahmet has been successfully added to your friend list.
This user is already in your friend list!
No such user!
Error: Please sign in and try again.
ix. Remove Friend: A user can also remove a user from his/her friend list. This operator
takes one argument that is a username.
REMOVEFRIEND<TAB>userName
Illustration of execution:
REMOVEFRIEND ahmet
ahmet has been successfully removed from your friend list.
No such friend!
Error: Please sign in and try again.
x. Add Text Post: User can create a new text post by specifying the text content, location
(longitude & latitude), and username of the friends who will be tagged to this post, each
of the usernames is separated by column (:) mark.
ADDPOST-TEXT<TAB>textContent<TAB>longitude<TAB>latitude<TAB> userName1<:>userName2<:>..<:>userNameN
Illustration of execution:
ADDPOST-TEXT 1st text post 39.88 32.73 ahmet:demet:adnan
The post has been successfully added.
ahmet is not your friend, and will not be tagged!
The post has been successfully added.
ahmet is not your friend, and will not be tagged!
demet is not your friend, and will not be tagged!
The post has been successfully added.
Error: Please sign in and try again.
xi. Add Image Post: A user can also create an image or a video post. In this scenario,
the image path and resolution information should be provided to the system as well.
ADDPOST-IMAGE<TAB>textContent<TAB>longitude<TAB>latitude<TAB> userName1<:>userName2<:>..<:>userNameN<TAB>filePath<TAB>resolution
Illustration of execution:
ADDPOST-IMAGE 1st image post 42.88 32.63 demet:gizem img.png 135x250
The post has been successfully added.
demet is not your friend, and will not be tagged!
The post has been successfully added.
demet is not your friend, and will not be tagged!
gizem is not your friend, and will not be tagged!
The post has been successfully added.
Error: Please sign in and try again.
xii. Add Video Post: User should only provide the file path and duration of the video.
ADDPOST-VIDEO<TAB>textContent<TAB>longitude<TAB>latitude<TAB> userName1<:>userName2<:>..<:>userNameN<TAB>filePath<TAB>videoDuration
Illustration of execution:
ADDPOST-VIDEO 1st video post 39.88 32.63 utku:gizem myvideo.avi 8
The post has been successfully added.
gizem is not your friend, and will not be tagged!
The post has been successfully added.
utku is not your friend, and will not be tagged!
gizem is not your friend, and will not be tagged!
The post has been successfully added.
Error: Your video exceeds maximum allowed duration of 10 minutes.
Error: Please sign in and try again.
xiii. Remove Post: User is able to remove a post that has been created the latest.
REMOVELASTPOST
Illustration of execution:
REMOVELASTPOST
Your last post has been successfully removed.
Error: You do not have any post.
Error: Please sign in and try again.
xiv. Block User: As in many of the real-world social platforms, a user may block another
user due to several reasons (disturbing posts, etc.) in mysocialbook as well. Users can
block any other user through her/his username as argument.
BLOCK<TAB>userName
Illustration of execution:
BLOCK ahmet
ahmet has been successfully blocked.
No such user!
Error: Please sign in and try again.
xv. Unblock User: The system should also allow a user to unblock another user who has
been blocked by him/her.
UNBLOCK<TAB>userName
Illustration of execution:
UNBLOCK ahmet
ahmet has been successfully unblocked.
No such user in your blocked-user list!
Error: Please sign in and try again.
xvi. List Friends: Users should be able to lists their friends no matter they are blocked or
not.
LISTFRIENDS
Illustration of execution:
LISTFRIENDS
You have not added any friend yet!
Error: Please sign in and try again.
Name: Adnan
Username: adnan
Date of Birth: 01/01/1991
School: Selcuk Universitesi
—————————
Name: Ahmet
Username: ahmet
Date of Birth: 04/25/2001
School: Meram Anadolu Lisesi
—————————
xvii. List Users: Users should be able to view all users in the system.
LISTUSERS
Illustration of execution:
LISTUSERS
Error: Please sign in and try again.
Name: Adnan
Username: adnan
Date of Birth: 01/01/1991
School: Selcuk Universitesi
—————————
Name: Ahmet
Username: ahmet
Date of Birth: 04/25/2001
School: Meram Anadolu Lisesi
—————————
xviii. Show Blocked Friends: Users should be able to lists their friends whom they have
blocked.
SHOWBLOCKEDFRIENDS
Illustration of execution:
SHOWBLOCKEDFRIENDS
You haven’t blocked any friend yet!
Error: Please sign in and try again.
Name: Adnan
Username: adnan
Date of Birth: 01/01/1991
School: Selcuk Universitesi
—————————
xix. Show Blocked Users: Similar to the previous scenario, users should be able to lists all
users whom they have blocked including no-friendship.
SHOWBLOCKEDUSERS
Illustration of execution:
SHOWBLOCKEDUSERS
You haven’t blocked any user yet!
Error: Please sign in and try again.
Name: Adnan
Username: adnan
Date of Birth: 01/01/1991
School: Selcuk Universitesi
—————————
Name: Ahmet
Username: ahmet
Date of Birth: 04/25/2001
School: Meram Anadolu Lisesi
—————————
Input and File for Commands
mysocialbook platform should read a tab-separated file named commands.txt. A detailed
explanation, format and expected output for each command is given before.
An exemplar for the content of this file is shown below:
ADDUSER Adnan adnan adnan1 01/01/1991 Selcuk Universitesi
REMOVEUSER 1
SIGNIN cemil cemil1
SIGNIN adnan adnan1
LISTUSERS
UPDATEPROFILE Adnan 07/01/1991 Gazi University
CHPASS adnan123 adnan1234
CHPASS adnan1 adnan123
ADDFRIEND ahmet
ADDFRIEND demet
ADDFRIEND demet
ADDFRIEND gizem
ADDFRIEND utku
ADDFRIEND ziya
REMOVEFRIEND zeki
REMOVEFRIEND ziya
REMOVEFRIEND utku
LISTFRIENDS
ADDPOST-TEXT 1st text post 39.2 32.81 ahmet
ADDPOST-IMAGE 1st image post 37.87 32.46 demet:gizem image.png 135x250
ADDPOST-VIDEO 1st video post 40.87 29.24 utku:gizem myvideo.avi 8
ADDPOST-TEXT 2nd text post 38.35 33.1 demet:gizem:utku
REMOVELASTPOST
SHOWPOSTS adnan
BLOCK demet
BLOCK gizem
BLOCK ahmet
SHOWBLOCKEDFRIENDS
UNBLOCK ziya
UNBLOCK gizem
UNBLOCK gizem
SHOWBLOCKEDFRIENDS
SHOWBLOCKEDUSERS
SIGNOUT
The output of mysocialbook when such commands.txt is provided is given below. It is worth
stressing here that you must print these to the screen not into any file!.
Command: ADDUSER Adnan adnan adnan1 01/01/1991 Selcuk Universitesi
Adnan has been successfully added.
-----------------------
Command: REMOVEUSER 1
User has been successfully removed.
-----------------------
Command: SIGNIN cemil cemil1
-----------------------
Command: SIGNIN adnan adnan1
You have successfully signed in.
-----------------------
Command: LISTUSERS
Name: Demet
Username: demet
Date of Birth: 01/16/1999
Username: Ankara Fen Lisesi
---------------------------
Name: Zeki
Username: zeki
Date of Birth: 08/16/1987
Username: Kadikoy Lisesi
---------------------------
Name: Gizem
Username: gizem
Date of Birth: 12/09/1997
Username: Hacettepe Universitesi
---------------------------
Name: Utku
Username: utku
Date of Birth: 10/06/1999
Username: Bilkent Universitesi
---------------------------
Name: Hakan
Username: hakan
Date of Birth: 03/01/1981
Username: Mugla S.K. ¨Universitesi
---------------------------
Name: Adnan
Username: adnan
Date of Birth: 01/01/1991
Username: Selcuk Universitesi
---------------------------
-----------------------
Command: UPDATEPROFILE Adnan 07/01/1991 Gazi University
-----------------------
Command: CHPASS adnan123 adnan1234
Password mismatch!
-----------------------
Command: CHPASS adnan1 adnan123
-----------------------
Command: ADDFRIEND ahmet
No such user!
-----------------------
Command: ADDFRIEND demet
demet has been successfully added to your friend list.
-----------------------
Command: ADDFRIEND demet
This user is already in your friend list!
-----------------------
Command: ADDFRIEND gizem
gizem has been successfully added to your friend list.
-----------------------
Command: ADDFRIEND utku
utku has been successfully added to your friend list.
-----------------------
Command: ADDFRIEND ziya
No such user!
-----------------------
Command: REMOVEFRIEND zeki
No such friend!
-----------------------
Command: REMOVEFRIEND ziya
Error: Please sign in and try again.
-----------------------
Command: REMOVEFRIEND utku
utku has been successfully removed from your friend list.
-----------------------
Command: LISTFRIENDS
Name: Demet
Username: demet
Date of Birth: 01/16/1999
Username: Ankara Fen Lisesi
---------------------------
Name: Gizem
Username: gizem
Date of Birth: 12/09/1997
Username: Hacettepe Universitesi
---------------------------
-----------------------
Command: ADDPOST-TEXT 1st text post 39.2 32.81 ahmet
ahmet is not your friend, and will not be tagged!
The post has been successfully added.
-----------------------
Command: ADDPOST-IMAGE 1st image post 37.87 32.46 demet:gizem image.png 135x250
The post has been successfully added.
-----------------------
Command: ADDPOST-VIDEO 1st video post 40.87 29.24 utku:gizem myvideo.avi 8
utku is not your friend, and will not be tagged!
The post has been successfully added.
-----------------------
Command: ADDPOST-TEXT 2nd text post 38.35 33.1 demet:gizem:utku
utku is not your friend, and will not be tagged!
The post has been successfully added.
-----------------------
Command: REMOVELASTPOST
Your last post has been successfully removed.
-----------------------
Command: SHOWPOSTS adnan
'''
--
Adnan's Posts
--
1st text post
Date: 05/08/2021
Location: 32.81, 39.2
----------------------
1st image post
Date: 05/08/2021
Location: 32.46, 37.87
Friends tagged in this post: Demet, Gizem
Image: image.png
Image resolution: 135x250
----------------------
1st video post
Date: 05/08/2021
Location: 29.24, 40.87
Friends tagged in this post: Gizem
Video: myvideo.avi
Video duration: 8.0 minutes
----------------------
'''
-----------------------
Command: BLOCK demet
demet has been successfully blocked.
-----------------------
Command: BLOCK gizem
gizem has been successfully blocked.
-----------------------
Command: BLOCK ahmet
No such user!
-----------------------
Command: SHOWBLOCKEDFRIENDS
Name: Demet
Username: demet
Date of Birth: 01/16/1999
Username: Ankara Fen Lisesi
---------------------------
Name: Gizem
Username: gizem
Date of Birth: 12/09/1997
Username: Hacettepe Universitesi
---------------------------
-----------------------
Command: UNBLOCK ziya
No such user!
-----------------------
Command: UNBLOCK gizem
gizem has been successfully unblocked.
-----------------------
Command: UNBLOCK gizem
No such user in your blocked-user list!
-----------------------
Command: SHOWBLOCKEDFRIENDS
Name: Demet
Username: demet
Date of Birth: 01/16/1999
Username: Ankara Fen Lisesi
---------------------------
-----------------------
Command: SHOWBLOCKEDUSERS
Name: Demet
Username: demet
Date of Birth: 01/16/1999
Username: Ankara Fen Lisesi
---------------------------
-----------------------
Command: SIGNOUT
You have successfully signed out.
Command for Running the Application
java MySocialBook users.txt commands.txt
Notes
• Your source code should be designed as easy-to-follow. Place comment in it as
much as possible. Create separate source code files for the tasks you handled.
• Use LATEX to prepare your reports. Include UML diagram showing class hierarchy of
mysocialbook. Once again, filled and signed declaration form should be first page of
your report. Reports must not exceed 5 pages in total.
• Do not miss the deadline.
• Save your work until the beginning of next semester.
• The assignment must be original, individual work. Duplicate or very similar
assignments are both going to be considered as cheating.
• You will submit your work on CENG1004 course page at https://dys.mu.edu.tr with the file
hierarchy as below2
:
→ <student id>.zip
→ src.zip3
→ Report.pdf
2do not place any file into a directory. Just compress the content files.
3
can contain packages.