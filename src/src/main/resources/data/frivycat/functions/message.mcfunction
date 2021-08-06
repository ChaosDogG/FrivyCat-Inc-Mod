tellraw @p [{"text":"Hello, and thanks for using the FrivyCat Inc. Datapack!","color":"green"},{"text":"\nThere are custom textures that this pack uses which you can obtain","color":"dark_green"},{"text":" here","bold":true,"hoverEvent":{"action":"show_text","value":[{"text":"Click me!"}]},"clickEvent":{"action":"run_command","value":"/give @p written_book{pages:['{\"text\":\"Click me!\",\"color\":\"light_purple\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://drive.google.com/open?id=1nAtizLzqgCuwmUDoZxy5kLnPDraS-o1F\"}}'],title:\"The FrivyCat Resource Pack\",author:FrivyCat}"}}]
summon armor_stand ~ ~ ~ {UUID:[I; -737892434, -1760673082, -2051667108, -973698162],Invisible:1,Invulnerable:1,DisabledSlots:1}
scoreboard objectives add lucky_blocks minecraft.picked_up:minecraft.player_head
scoreboard players set d404a7ae-970e-42c6-85b6-0b5cc5f68b8e lucky_blocks 999
scoreboard objectives add lb_break minecraft.mined:minecraft.player_head [{"text":"Lucky Blocks Broken","color":"gold"}]
scoreboard objectives setdisplay sidebar lb_break
scoreboard objectives add hp health
scoreboard objectives setdisplay list hp
tag @e[tag=transformed] remove transformed
schedule function frivycat:sidebar2 50t replace