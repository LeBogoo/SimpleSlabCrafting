package me.lebogo.simpleSlabCrafting;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class SimpleSlabCrafting extends JavaPlugin {

    private static final Map<Material, Material> slabBlockMap = new HashMap<>();

    static {
        slabBlockMap.put(Material.CUT_COPPER_SLAB, Material.CUT_COPPER);
        slabBlockMap.put(Material.EXPOSED_CUT_COPPER_SLAB, Material.EXPOSED_CUT_COPPER);
        slabBlockMap.put(Material.WEATHERED_CUT_COPPER_SLAB, Material.WEATHERED_CUT_COPPER);
        slabBlockMap.put(Material.OXIDIZED_CUT_COPPER_SLAB, Material.OXIDIZED_CUT_COPPER);
        slabBlockMap.put(Material.WAXED_CUT_COPPER_SLAB, Material.WAXED_CUT_COPPER);
        slabBlockMap.put(Material.WAXED_EXPOSED_CUT_COPPER_SLAB, Material.WAXED_EXPOSED_CUT_COPPER);
        slabBlockMap.put(Material.WAXED_WEATHERED_CUT_COPPER_SLAB, Material.WAXED_WEATHERED_CUT_COPPER);
        slabBlockMap.put(Material.WAXED_OXIDIZED_CUT_COPPER_SLAB, Material.WAXED_OXIDIZED_CUT_COPPER);
        slabBlockMap.put(Material.OAK_SLAB, Material.OAK_PLANKS);
        slabBlockMap.put(Material.SPRUCE_SLAB, Material.SPRUCE_PLANKS);
        slabBlockMap.put(Material.BIRCH_SLAB, Material.BIRCH_PLANKS);
        slabBlockMap.put(Material.JUNGLE_SLAB, Material.JUNGLE_PLANKS);
        slabBlockMap.put(Material.ACACIA_SLAB, Material.ACACIA_PLANKS);
        slabBlockMap.put(Material.CHERRY_SLAB, Material.CHERRY_PLANKS);
        slabBlockMap.put(Material.DARK_OAK_SLAB, Material.DARK_OAK_PLANKS);
        slabBlockMap.put(Material.MANGROVE_SLAB, Material.MANGROVE_PLANKS);
        slabBlockMap.put(Material.BAMBOO_SLAB, Material.BAMBOO);
        slabBlockMap.put(Material.BAMBOO_MOSAIC_SLAB, Material.BAMBOO_MOSAIC);
        slabBlockMap.put(Material.CRIMSON_SLAB, Material.CRIMSON_PLANKS);
        slabBlockMap.put(Material.WARPED_SLAB, Material.WARPED_PLANKS);
        slabBlockMap.put(Material.STONE_SLAB, Material.STONE);
        slabBlockMap.put(Material.SMOOTH_STONE_SLAB, Material.SMOOTH_STONE);
        slabBlockMap.put(Material.SANDSTONE_SLAB, Material.SANDSTONE);
        slabBlockMap.put(Material.CUT_SANDSTONE_SLAB, Material.CUT_SANDSTONE);
        slabBlockMap.put(Material.COBBLESTONE_SLAB, Material.COBBLESTONE);
        slabBlockMap.put(Material.BRICK_SLAB, Material.BRICK);
        slabBlockMap.put(Material.STONE_BRICK_SLAB, Material.STONE_BRICKS);
        slabBlockMap.put(Material.MUD_BRICK_SLAB, Material.MUD_BRICKS);
        slabBlockMap.put(Material.NETHER_BRICK_SLAB, Material.NETHER_BRICK);
        slabBlockMap.put(Material.QUARTZ_SLAB, Material.QUARTZ);
        slabBlockMap.put(Material.RED_SANDSTONE_SLAB, Material.RED_SANDSTONE);
        slabBlockMap.put(Material.CUT_RED_SANDSTONE_SLAB, Material.CUT_RED_SANDSTONE);
        slabBlockMap.put(Material.PURPUR_SLAB, Material.PURPUR_BLOCK);
        slabBlockMap.put(Material.PRISMARINE_SLAB, Material.PRISMARINE);
        slabBlockMap.put(Material.PRISMARINE_BRICK_SLAB, Material.PRISMARINE_BRICKS);
        slabBlockMap.put(Material.DARK_PRISMARINE_SLAB, Material.DARK_PRISMARINE);
        slabBlockMap.put(Material.POLISHED_GRANITE_SLAB, Material.POLISHED_GRANITE);
        slabBlockMap.put(Material.SMOOTH_RED_SANDSTONE_SLAB, Material.SMOOTH_RED_SANDSTONE);
        slabBlockMap.put(Material.MOSSY_STONE_BRICK_SLAB, Material.MOSSY_STONE_BRICKS);
        slabBlockMap.put(Material.POLISHED_DIORITE_SLAB, Material.POLISHED_DIORITE);
        slabBlockMap.put(Material.MOSSY_COBBLESTONE_SLAB, Material.MOSSY_COBBLESTONE);
        slabBlockMap.put(Material.END_STONE_BRICK_SLAB, Material.END_STONE_BRICKS);
        slabBlockMap.put(Material.SMOOTH_SANDSTONE_SLAB, Material.SMOOTH_SANDSTONE);
        slabBlockMap.put(Material.SMOOTH_QUARTZ_SLAB, Material.SMOOTH_QUARTZ);
        slabBlockMap.put(Material.GRANITE_SLAB, Material.GRANITE);
        slabBlockMap.put(Material.ANDESITE_SLAB, Material.ANDESITE);
        slabBlockMap.put(Material.RED_NETHER_BRICK_SLAB, Material.RED_NETHER_BRICKS);
        slabBlockMap.put(Material.POLISHED_ANDESITE_SLAB, Material.POLISHED_ANDESITE);
        slabBlockMap.put(Material.DIORITE_SLAB, Material.DIORITE);
        slabBlockMap.put(Material.COBBLED_DEEPSLATE_SLAB, Material.COBBLED_DEEPSLATE);
        slabBlockMap.put(Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE);
        slabBlockMap.put(Material.DEEPSLATE_BRICK_SLAB, Material.DEEPSLATE_BRICKS);
        slabBlockMap.put(Material.DEEPSLATE_TILE_SLAB, Material.DEEPSLATE_TILES);
        slabBlockMap.put(Material.BLACKSTONE_SLAB, Material.BLACKSTONE);
        slabBlockMap.put(Material.POLISHED_BLACKSTONE_SLAB, Material.POLISHED_BLACKSTONE);
        slabBlockMap.put(Material.POLISHED_BLACKSTONE_BRICK_SLAB, Material.POLISHED_BLACKSTONE_BRICKS);

    }

    @Override
    public void onEnable() {

        for (Material material : slabBlockMap.keySet()) {
            registerRecipe(material, slabBlockMap.get(material));
        }
    }

    private void registerRecipe(Material slabMaterial, Material blockMaterial) {
        ItemStack slab = new ItemStack(slabMaterial);
        ItemStack block = new ItemStack(blockMaterial);
        NamespacedKey key = new NamespacedKey(this, blockMaterial.toString().toLowerCase());
        getServer().addRecipe(new ShapelessRecipe(key, block).addIngredient(slab).addIngredient(slab));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
