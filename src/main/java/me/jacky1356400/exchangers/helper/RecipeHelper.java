package me.jacky1356400.exchangers.helper;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreIngredient;

public class RecipeHelper {

    private static int j = 0;

    /*
     * This adds the recipe to the list of crafting recipes.  Since who cares about names, it adds it as recipesX, where X is the current recipe you are adding.
     */
    public static IRecipe addRecipe(int j, IRecipe rec){
        return rec;
    }

    public static IRecipe getShapeless(Block output, Object[] inputs){
        return addRecipe(j++, new ShapelessRecipes(String.valueOf(j), new ItemStack(output), createInput(inputs)));
    }

    public static ShapedRecipes getShaped(ItemStack output, int l, int w, Object[] input){
        if(l * w != input.length) throw new UnsupportedOperationException("Attempted to add invalid shaped recipe. Please contact the author of Simple Sponge.");
        NonNullList<Ingredient> inputL = NonNullList.create();
        for(int i = 0; i < input.length; i++){
            Object k = input[i];
            if(k instanceof String){
                inputL.add(i, new OreIngredient((String) k));
            }
            else if(k instanceof ItemStack){
                inputL.add(i, Ingredient.fromStacks((ItemStack)k));
            }
            else if(k instanceof Item){
                inputL.add(i, Ingredient.fromItem((Item)k));
            }
            else if(k instanceof Block){
                inputL.add(i, Ingredient.fromStacks(new ItemStack((Block)k)));
            }
            else{
                inputL.add(i, Ingredient.EMPTY);
            }
        }

        return new ShapedRecipes(String.valueOf(j), l, w, inputL, output);
    }


    public static NonNullList<Ingredient> createInput(Object[] input){
        NonNullList<Ingredient> inputL = NonNullList.create();
        for(int i = 0; i < input.length; i++){
            Object k = input[i];
            if(k instanceof String){
                inputL.add(i, new OreIngredient((String) k));
            }
            else if(k instanceof ItemStack){
                inputL.add(i, Ingredient.fromStacks((ItemStack)k));
            }
            else if(k instanceof Item){
                inputL.add(i, Ingredient.fromItem((Item)k));
            }
            else if(k instanceof Block){
                inputL.add(i, Ingredient.fromStacks(new ItemStack((Block)k)));
            }
            else{
            }
        }
        return inputL;
    }

}