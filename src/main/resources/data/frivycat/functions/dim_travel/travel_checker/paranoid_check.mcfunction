execute as @a[distance=..3] if entity @s[predicate=!frivycat:paranoid_dim_item] run function frivycat:dim_travel/travel_fail
execute as @a[distance=..3] if entity @s[predicate=frivycat:paranoid_dim_item] run function frivycat:dim_travel/success/paranoid_dim_travel