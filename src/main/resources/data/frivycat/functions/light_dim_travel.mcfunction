execute in chaos:light_overworld as @s run tp ~ ~ ~
clear @s enchanted_golden_apple 1
execute at @s run fill ~2 ~-1 ~2 ~-2 ~2 ~-2 air
execute at @s run fill ~2 ~-2 ~2 ~-2 ~-2 ~-2 bedrock
execute at @s run setblock ~ ~ ~ shroomlight
execute at @s run title @s title {"text":"Light Overworld","color":"aqua","italic":false}