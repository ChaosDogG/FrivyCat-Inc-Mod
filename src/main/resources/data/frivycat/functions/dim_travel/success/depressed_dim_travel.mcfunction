execute in frivycat:depressed_badlands as @s run tp ~ ~ ~
clear @s dead_brain_coral 1
execute at @s run title @s title {"text":"Depressed Badlands","color":"dark_gray","italic":false}
execute in frivycat:depressed_badlands run schedule function frivycat:dim_travel/success/dim_pad 0.5t replace