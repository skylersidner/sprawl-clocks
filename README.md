# Sprawl Clocks Project
Built off of my friend's base java app for Heroku (check him out: https://github.com/liester). The front end for this project is [here](https://github.com/skylersidner/sprawl-clocks-front).

When playing *[The Sprawl](https://www.kickstarter.com/projects/ardensludere/the-sprawl-cyberpunk-roleplaying-powered-by-the-ap)* I realized I wanted a better way to display the current status of each clock, to be more aware of what kinds of threats our team was up against and how bad things were getting.

This is designed to do basic CRUD for clocks and display them in useful ways.

Clock.class
ClockType clockType: (Corporate/Threat)
String name: (“Daedalus Innovation”)
TimeType time: (1200 (default)/1500/1800/2100/2200/2300/0000)
String description: ()
 
 
* Use cards to READ (display) these; sort into arrays by type
* Way to CREATE new clocks
* Way to UPDATE clocks (like time value)
* Way to DELETE clocks
* Sorting by attribute
* Filtering by attribute
* Color spectra for level (Blue/Green/Yellow/Yellow/Red/Red/???)
* Widget to display time attribute that resembles clocks from game and colors accordingly
* Way for admin to log in; put C*UD behind this
* Way to create new clock types?
* Animation for landing page; fade in for page, header/footer slide into fixed position at top/bottom
* Animation for sorting or display?
