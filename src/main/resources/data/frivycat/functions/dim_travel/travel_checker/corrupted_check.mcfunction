execute as @a[distance=..3] if entity @s[predicate=!frivycat:corrupted_dim_item] run function frivycat:dim_travel/travel_fail
execute as @a[distance=..3] if entity @s[predicate=frivycat:corrupted_dim_item] run function frivycat:dim_travel/success/corrupted_dim_travel