/**
 * Tests for class Recipe.
 *
 * All tests in the folder "test" are executed
 * when the "Test" action is invoked.
 *
 */

package exercises.lesson3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class RecipeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public final void testMain() {
        NutritionApp.firstExercise();
        String firstParagraph = "Crock Pot Roast\n\tingredients:\n\t\t1 beef roast, Meat\n\t\t1 package brown gravy mix, Baking\n\t\t1 package dried Italian salad dressing mix, Condiments\n\t\t1 package dry ranch dressing mix, Condiments\n\t\t1/2 cup water, Drinks\n\tsteps:\n\t\t1. Place beef roast in crock pot\n\t\t2. Mix the dried mixes together in a bowl and sprinkle over the roast.\n\t\t3. Pour the water around the roast.\n\t\t4. Cook on low for 7-9 hours.";
        String secondParagraph = "\nRoasted asparagus\n\tingredients:\n\t\t1 lb asparagus, Produce\n\t\t1 1/2 tbsp olive oil, Condiments\n\t\t1/2 tsp kosher salt, Baking\n\tsteps:\n\t\t1. Preheat oven to 425F.\n\t\t2. Cut off the woody bottom part of the asparagus spears and discard.\n\t\t3. With a vegetable peeler, peel off the skin on the bottom 2-3 inches of the spears.\n\t\t4. Place asparagus on foil-lined baking sheet and drizzle with olive oil.\n\t\t5. Sprinkle with salt.\n\t\t6. With your hands, roll the asparagus around until they are evenly coated with oil and salt.\n\t\t7. Roast for 10-15 minutes, depending on the thickness of your stalks and how tender you like them.\n\t\t8. They should be tender when pierced with the tip of a knife.\n\t\t9. The tips of the spears will get very brown but watch them to prevent burning.\n\t\t10. They are great plain, but sometimes I serve them with a light vinaigrette if we need something acidic to balance out our meal.";
        String thirdParagraph = "\nCurried Lentils and Rice\n\tingredients:\n\t\t1 quart beef broth, Misc\n\t\t1 cup dried green lentils, Misc\n\t\t1/2 cup basmati rice, Misc\n\t\t1 tsp curry powder, Condiments\n\t\t1 tsp salt, Condiments\n\tsteps:\n\t\t1. Bring broth to a low boil.\n\t\t2. Add curry powder and salt.\n\t\t3. Cook lentils for 20 minutes.\n\t\t4. Add rice and simmer for 20 minutes.\n";
        String completeParagraph = firstParagraph + secondParagraph + thirdParagraph;
        assertEquals(completeParagraph,outContent.toString());
    }

    @Test
    public final void testSecond() {
        NutritionApp.secondExercise();
        File favoriteRecipe = new File("/home/eduardo/IdeaProjects/JavaAndroid/src/exercises/lesson3/favorite_recipe.txt");
        assertTrue(favoriteRecipe.isFile());

        NutritionApp.thirdExercise();
        String favorite = "Crock Pot Roast\ningredients: 5\nsteps: 4\n";
        try{
            assertThat(outContent.toString("utf-8"), containsString(favorite));
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}

