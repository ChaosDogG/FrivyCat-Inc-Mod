team join friendly @e[tag=friendly,type=!player]
execute as @e[name=Friendly,tag=!friendly] run data merge entity @s {Tags:["friendly"],CustomName:'{"text":""}',PersistenceRequired:1}
team join friendly @a[gamemode=survival,team=!friendly]
team join friendly @e[type=villager,team=!friendly]
team join friendly @e[type=wandering_trader,team=!friendly]
team join friendly @e[type=iron_golem,team=!friendly]
team join friendly @e[type=snow_golem,team=!friendly]