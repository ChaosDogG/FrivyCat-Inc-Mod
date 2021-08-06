team join Corrupted @e[tag=corrupted,type=!player]
execute as @e[team=Corrupted,tag=!aftercorrupt,type=!player,type=!bat] run attribute @s generic.max_health base set 400
execute as @e[team=Corrupted,tag=!aftercorrupt,type=!player,type=!bat] run attribute @s generic.attack_damage base set 5
execute as @e[team=Corrupted,tag=!aftercorrupt,type=!player,type=!bat] run attribute @s generic.follow_range base set 100
execute as @e[team=Corrupted,tag=!aftercorrupt,type=!player,type=!bat] run attribute @s generic.movement_speed base set .4
execute as @e[type=creeper,team=Corrupted,tag=!aftercorrupt] run data merge entity @s {ExplosionRadius:6}
execute as @e[type=vindicator,team=Corrupted,tag=!aftercorrupt] run data merge entity @s {Johnny:1}
execute as @e[team=Corrupted,tag=!aftercorrupt,type=!player,type=!bat] run data merge entity @s {DeathLootTable:"frivycat:entities/corrupted_drops",PersistenceRequired:1}
execute as @e[team=Corrupted,tag=!aftercorrupt,type=!player,type=!bat] run data merge entity @s {Health: 400}
tag @e[team=Corrupted,nbt={DeathLootTable:"frivycat:entities/corrupted_drops"},type=!player] add aftercorrupt