execute in frivycat:malicious_dark_forest as @s run tp ~ ~ ~
clear @s wither_skeleton_skull 1
execute at @s run title @s title {"text":"Malicious Dark Forest","color":"#212121","italic":false}
execute in frivycat:malicious_dark_forest run schedule function frivycat:dim_travel/success/dim_pad 0.5t replace