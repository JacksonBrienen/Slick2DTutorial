<head>
    <style>
        #menu-options{
            /* background-color: darkgray; */
            position: fixed;
            top: 0px;
            right: 40px;
            width:200px;
            height: calc(35 * 3)px;
            display: none;
        }
        #menu-icon{
            width: 35px;
            position: fixed;
            top: 5px;
            right: 5px;
        }
        #menu-icon:hover+#menu-options,#menu-icon:hover+#menu-options:hover{
            display: block;
        }
        #menu-options:hover{
            display: block;
        }
        .menu-button{
            background-color: black;
            color: lightgray;
            text-align: center;
            border-width: 3px;
            border-style: solid;
            border-color: lightgray;
            border-radius: 8px;
            margin: 0;
            margin-bottom: 1px;
            min-height: 35px;
            user-select: none; /* supported by Chrome and Opera */
            -webkit-user-select: none; /* Safari */
            -khtml-user-select: none; /* Konqueror HTML */
            -moz-user-select: none; /* Firefox */
            -ms-user-select: none;
        }
        .menu-button:hover{
            border-color: gray;
        }
        .menu-button:active{
            border-color: darkgray;
        }
    </style>
</head>
<body>
    <img id="menu-icon" src="https://icon-library.com/images/three-line-menu-icon/three-line-menu-icon-1.jpg">
    <div id="menu-options">
        <a href="#description" style="text-decoration: none;"><div class="menu-button">Description</div></a>
        <a href="#setup" style="text-decoration: none;"><div class="menu-button">First Time Setup</div></a>
        <a href="#individual-downloads" style="text-decoration: none;"><div class="menu-button">Individual Downloads</div></a>
    </div>
    <div id="description">
        <h1>Slick2D Tutorial</h1>
        <p>Simple Slick2D Tutorials in Eclipse<br><br>
        Small note: These tutorials are for beginner-level programmers and game developers that have an entry-level understanding of object-oriented programming in java. Slick2D has been out of development for around 9 years, if you are looking for professional-level game development in java I would highly recommend <a href="https://www.lwjgl.org/" target="_blank">LWJGL</a> or <a href="https://libgdx.com/" target="_blank">LibGDX</a>.<br><br>
        <a href="https://slick.ninjacave.com/" target="_blank">Slick2D Download Link</a></p>
    </div>
    <div id="setup">
        <h1>Setting up your First Project</h1>
        <ol>
            <li>Let's start from a blank Eclipse project, I am using update 2021-12 but these steps should work with all modern versions of eclipse. Let's start by creating a new project, we can simply hit the create new project button.</li>
            <img src="images/step00.png" style="max-width: 650px;">
            <li>I will name my project "Example" but you can name your project however you wish. One small note, since Slick2D is a bit dated we need to ensure that we are running it in Java 1.8, for most of you you should have to worry about this, but if you have another one selected make sure to change it to 1.8</li>
            <img src="images/step01.png" style="max-width: 650px;">
            <li>Next, we will need to import the Slick2D Framework, to start let's download it, you can <a href="https://slick.ninjacave.com/slick.zip">Click This</a> to download the zipped Slick2D folder. Now we will need to unzip the folder, you can do this by simply navigating to the file in your downloads folder(or wherever you downloaded it) right-clicking on the slick.zip file, and selecting "Extract All..."</li>
            <img src="images/step02.png" style="max-width: 650px;">
            <li>Then a window will open up prompting you to extract the zip, click the "Extract" button.</li>
            <img src="images/step03.png" style="max-width: 650px;">
            <li>After doing this, navigate back to eclipse and right-click on your project, hover over "Build Path", then select "Configure Build Path".</li>
            <img src="images/step04.png" style="max-width: 650px;">
            <li>A new window will pop up, on the right side of this window click "Add Library"</li>
            <img src="images/step05.png" style="max-width: 650px;">
            <li>Another window will appear, on the middle section of this window select "User Library", then click "Next"</li>
            <img src="images/step06.png" style="max-width: 650px;">
            <li>Now select "User Libraries..."</li>
            <img src="images/step07.png" style="max-width: 650px;">
            <li>Now select "New"</li>
            <img src="images/step08.png" style="max-width: 650px;">
            <li>To explain what we are doing, we are going to create a User Library that holds all the files that we need for Slick2D, this will make it easier to import into new projects that we make in the future. Now we need to enter the Libraries name, enter "Slick2D" into the text field, then press "OK"</li>
            <img src="images/step09.png" style="max-width: 650px;">
            <li>Now click on "Add External JARs..."</li>
            <img src="images/step10.png" style="max-width: 650px;">
            <li>Now navigate to your slick unzipped folder, and once in the folder enter the "lib" folder. Once inside the lib folder select everything in the folder, then press "Open"</li>
            <img src="images/step11.png" style="max-width: 650px;">
            <li>Now scroll through the imported JARs and find the one titled "slick.jar" and make sure the drop-down arrow is clicked, in this drop-down menu double click on the section titled "Javadoc location: (None)"</li>
            <img src="images/step12.png" style="max-width: 650px;">
            <li>A new window will pop up, select "Browse..."</li>
            <img src="images/step13.png" style="max-width: 650px;">
            <li>Navigate to your slick folder again, and select the folder "javadoc", then click the "Select" button.</li>
            <img src="images/step14.png" style="max-width: 650px;">
            <li>Click Apply and Close</li>
            <img src="images/step15.png" style="max-width: 650px;">
            <li>Click "Finish" and then click "Apply and Close"</li>
            <img src="images/step16.png" style="max-width: 650px;">
            <li>For our projects, we will use Packages to organize our code. Right-click on your "src" folder hover over "new" and then click on "Package"</li>
            <img src="images/step17.png" style="max-width: 650px;">
            <li>Here I use standard Package naming conventions, but you can use any naming you wish. Packages are very similar to directories, instead of using a <b>/</b> or <b>\</b> we use a <b>.</b> to separate different "packages" or folders. For what we are doing here you could simply use your project name as your root package, so for me, it would be "example", or if you were making a pong game your root package could simply be "pong". But for now, pick whatever name you would like, then click "Finish"</li>
            <img src="images/step18.png" style="max-width: 650px;">
            <li>Now right click on our root package that we just created, hover over "new", then click "Class"</li>
            <img src="images/step19.png" style="max-width: 650px;">
            <li>Now will create our main Game class, we will title this class a very fitting name of "Game", then click "Finish"</li>
            <img src="images/step20.png" style="max-width: 650px;">
            <li>Lets also create one more Class</li>
            <img src="images/step21.png" style="max-width: 650px;">
            <li>Lets also create one more Class</li>
            <img src="images/step21.png" style="max-width: 650px;">
            <li>This one we will title "Launcher", we also want to check to include a main method, this is where we will Launch our game from, finally, click "Finish"</li>
            <img src="images/step22.png" style="max-width: 650px;">
            <li>We are almost to writing code but before we get there we need to import one more piece from Slick2D, to do this we need to start by creating a new directory, right-click on your project, hover over new, and select "Folder"</li>
            <img src="images/step23.png" style="max-width: 650px;">
            <li>Name the Folder "native", the naming is very important! Then click "Finish"</li>
            <img src="images/step24.png" style="max-width: 650px;">
            <li>Now we get to write our code, we won't go too in-depth, that's for later, but we will write a very simple game class. Notice how we extend BasicGame, this is needed for us to get and use the methods init, render, and update. Along with that we also get the constructor, this constructor gets an argument of a String which will be the title of our window.</li>
            <img src="images/step25.png" style="max-width: 650px;">
            <li>Next, we need our launcher for our game, in here we need to do a few things. Notice the first three lines, the first line is getting a String that is the path to our "native" folder, the next two lines load those libraries which are needed for Slick2D to function properly. Next, we make an AppGameContainer, notice the 4 arguments, the first one is our Game, the next two are the width and height of our game, the last one is if we want our game fullscreen or not, in this case, we put false so that it is windowed. Finally we "start" our display, this creates our window and calls our games init method.</li>
            <img src="images/step26.png" style="max-width: 650px;">
            <li>Finally, we run our program, and we get to see our window. If you followed everything properly you should get a display like this. If you are having problems, you can refer to the project directory under the name "Example".</li>
            <img src="images/step27.png" style="max-width: 650px;">
        </ol>
    </div>
    <div id="individual-downloads">
        <h1>Individual File Downloads</h1>
        <ul>
            <li><a href="https://kinolien.github.io/gitzip/?download=/JacksonBrienen/Slick2DTutorial/tree/main/Example/" target="_self">Example</a></li>
        </ul>
    </div>
</body>