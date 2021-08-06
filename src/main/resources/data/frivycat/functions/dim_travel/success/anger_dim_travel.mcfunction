execute in frivycat:enraged_nether_wastes as @s run tp ~ ~ ~
clear @s damaged_anvil 1
execute at @s run title @s title {"text":"Enraged Nether Wastes","color":"red","italic":false}
schedule function frivycat:dim_travel/success/dim_pad 0.5t replace