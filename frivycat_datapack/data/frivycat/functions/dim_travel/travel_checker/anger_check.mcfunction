execute as @a[distance=..3] if entity @s[predicate=!frivycat:anger_dim_item] run function frivycat:dim_travel/travel_fail
execute as @a[distance=..3] if entity @s[predicate=frivycat:anger_dim_item] run function frivycat:dim_travel/success/anger_dim_travel