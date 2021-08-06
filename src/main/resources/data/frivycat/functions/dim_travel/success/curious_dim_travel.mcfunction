execute in frivycat:curious_overworld as @s run tp ~ ~ ~
clear @s command_block 1
execute at @s run title @s title {"text":"Curious Overworld","color":"gold","italic":false}
schedule function frivycat:dim_travel/success/dim_pad 0.5t replace