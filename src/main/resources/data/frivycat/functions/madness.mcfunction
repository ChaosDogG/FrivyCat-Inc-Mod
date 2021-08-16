summon bat ~3 ~3 ~ {Passengers:[{id:illusioner,HandItems:[{id:bow,Count:1},{id:spectral_arrow,Count:1}],Tags:["corrupted","boss"]}],Tags:["corrupted"]}
summon bat ~-3 ~3 ~ {Passengers:[{id:illusioner,HandItems:[{id:bow,Count:1},{id:spectral_arrow,Count:1}],Tags:["corrupted","boss"]}],Tags:["corrupted"]}
summon bat ~ ~3 ~3 {Passengers:[{id:illusioner,HandItems:[{id:bow,Count:1},{id:spectral_arrow,Count:1}],Tags:["corrupted","boss"]}],Tags:["corrupted"]}
summon bat ~ ~3 ~-3 {Passengers:[{id:piglin,IsImmuneToZombification:1,HandItems:[{id:crossbow,Count:1},{id:spectral_arrow,Count:1}],Tags:["corrupted","boss"]}],Tags:["corrupted"]}
summon bat ~3 ~3 ~3 {Passengers:[{id:piglin,IsImmuneToZombification:1,HandItems:[{id:crossbow,Count:1},{id:spectral_arrow,Count:1}],Tags:["corrupted","boss"]}],Tags:["corrupted"]}
summon bat ~-3 ~3 ~-3 {Passengers:[{id:piglin,IsImmuneToZombification:1,HandItems:[{id:crossbow,Count:1},{id:spectral_arrow,Count:1}],Tags:["corrupted","boss"]}],Tags:["corrupted"]}
summon hoglin ~3 ~ ~ {Passengers:[{id:rabbit,RabbitType:99,Tags:["corrupted","boss"]}],Tags:["corrupted","boss"],IsImmuneToZombification:1}
summon hoglin ~-3 ~ ~ {Passengers:[{id:rabbit,RabbitType:99,Tags:["corrupted","boss"]}],Tags:["corrupted","boss"],IsImmuneToZombification:1}
summon hoglin ~ ~ ~3 {Passengers:[{id:rabbit,RabbitType:99,Tags:["corrupted","boss"]}],Tags:["corrupted","boss"],IsImmuneToZombification:1}
summon phantom ~3 ~3 ~ {Passengers:[{id:"minecraft:ravager",Tags:["corrupted","madness","boss"]}],ArmorItems:[{},{},{},{id:"minecraft:acacia_button",Count:1b}],ActiveEffects:[{Id:12b,Amplifier:255b,Duration:5000,ShowParticles:0b}],Tags:["corrupted","boss"]}
summon phantom ~-3 ~3 ~ {Passengers:[{id:"minecraft:ravager",Tags:["corrupted","madness","boss"]}],ArmorItems:[{},{},{},{id:"minecraft:acacia_button",Count:1b}],ActiveEffects:[{Id:12b,Amplifier:255b,Duration:5000,ShowParticles:0b}],Tags:["corrupted","boss"]}
summon vindicator ~3 ~ ~3 {Tags:["corrupted","boss"],Passengers:[{id:blaze,Tags:["corrupted","boss"]}],HandItems:[{id:netherite_axe,Count:1,tag:{Unbreakable:1}},{}]}

tag @e[tag=!friendly,type=#frivycat:hostiles] add corrupted
playsound entity.enderman.stare master @a ~ ~ ~ 100000 0
tellraw @a [{"text":"You hear the sounds of corruption as the madness ensues. ","color":"dark_red"},{"text":"You sense the corruption hitting all the mobs around you","color":"dark_purple"}]

advancement grant @s only frivycat:actions/madness
kill @e[type=item_frame,nbt={Item:{id:"frivycat:garnet",Count:1b}}]
scoreboard players add @s h 1