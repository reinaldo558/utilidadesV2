# utilidadesV2
A utility software created to help my daily work a few years ago

Within this project, there are working examples of (tested with Java6 and windows 7 environment):
 - System tray Icon and Menu
 - Swing panels, tabs, labels, actions, buttons, texts, tree view, dropdown, radio, checkbox, slider and other
 - Calendar manipulation with multiple formats
 - CPF algorithms (Person ID for Brazil)
 - Cryptography 
 - Password management
 - Terminal manipulation (remote connection)
 
# Purpose and main functionalities
This project started while needing many simple information for my daily activities, for development in the company's environment, production support and servers management, I was already creating Unix shell scripts to help me with those tasks but some information or even tasks could be more automated or simplified, so instead of having myself connecting to a remote environment to execute a set of commands or shell scripts, I created a single Swing application that stayed hidden in the Windows SystemTray, where I needed only to press a button on the PopUp menu to get a piece of information or execute a remote task.
With time, and me needing to have access to more than 30 different machines, the project became bigger and I even created a password manager in it, encrypting all passwords, and making this project start the remote connections already logged in for me whenever possible, so instead of having to memorize 30+ users and passwords, I needed only two, one for the windows/network and another for this program.

Besides simple tasks on the PopUp menu, this program  have (had?):

[TAB "Crypto"]
 - Connection and password management, on the left side a Tree View with all my registered remote connections divided by system, environment or type, on the right side some buttons to manage the connections, a set of buttons to show/hide information of the selected system, a set of buttons to manage the password, a set of buttons to open one or multiple connections with possibility to automatically open a putty, Unux shell, web browser or other personalized program, and a set of buttons to add or remove systems.
 
[TAB "CPF"]
 - A panel with many possible ways to create CPFs (Person ID for Brazil), one or many, random or with a specific  prefix.
 
[TAB "Direct"]
 - Before uploading the project here I removed all sensible information on this area. Here it was possible to remotely execute a set of business related commands on many different servers and get the results already formatted. This tab also has history of commands, templates, and some converters.
 
[TAB "CVC"]
 - Other business related tab, to create or validate business related codes
 
[TAB "StrRplc"]
 - Many business and technical ways to convert strings, simple words or phrases pasted direct into this window or direct into files.
 
[TAB "Calendario"] (Calendar)
 - A Calendar view similar to any other calendar, showing a moth/year and its days, with previous/next selection, but showing both Gregorian Calendar and Julian Calendar. This tab also have some filters to quickly show a specific month/year.  


# Password Management
The Private Key used by this program is created automatically and randomly upon its first start in a different computer, and parts of the key consists of user and machine information, so just copying the jar and configuration files from one machine to another does not allow the passwords to be accessed. 



