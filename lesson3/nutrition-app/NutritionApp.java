package exercises.lesson3;

import javax.json.*;
import javax.json.spi.JsonProvider;

import java.io.*;

class NutritionApp {
    static void firstExercise() {
        JsonReader reader = null;
        try {
            reader = Json.createReader(new FileReader("src/exercises/lesson3/recipes.json"));

            JsonStructure jstruct = reader.read();

            printDietJson(jstruct);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    private static void printDietJson(JsonValue tree) {
        switch (tree.getValueType()) {
            case OBJECT:
                JsonObject object = (JsonObject) tree;
                for (String key : object.keySet()) {
                    switch (key) {
                        case "name":
                            System.out.println(object.get(key).toString().replace("\"", ""));
                            break;
                        case "ingredients":
                            System.out.println("\t" + key + ":");
                            JsonArray ing = (JsonArray) object.get(key);
                            for (JsonValue val : ing) {
                                System.out.println("\t\t" + val.toString().replace("\"", ""));
                            }
                            break;
                        case "steps":
                            System.out.println("\t" + key + ":");
                            JsonArray steps = (JsonArray) object.get(key);
                            for (int i = 1; i <= steps.size(); i++) {
                                JsonValue step = steps.get(i-1);
                                System.out.println("\t\t" + i + ". " + step.toString().replace("\"", ""));
                            }
                            break;
                    }
                }
                break;
            case ARRAY:
                JsonArray array = (JsonArray) tree;
                for (JsonValue val : array) {
                    printDietJson(val);
                }
                break;
            case NUMBER:
            case TRUE:
            case FALSE:
            case STRING:
            case NULL:
                break;
        }
    }

    static void secondExercise() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/home/eduardo/IdeaProjects/JavaAndroid/src/exercises/lesson3/recipes.txt"));

            Recipe myRecipe = generateRecipe(reader);

            FileOutputStream stream = new FileOutputStream("/home/eduardo/IdeaProjects/JavaAndroid/src/exercises/lesson3/favorite_recipe.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(stream);

            outputStream.writeObject(myRecipe);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Recipe generateRecipe(BufferedReader reader) {
        Recipe result = null;
        String line;
        try {
            int rec = 0, ing = 0, steps = 0;
            String name = "";
            while ((line = reader.readLine()) != null) {
                if (rec == 0) name = line;
                line = reader.readLine();

                line = reader.readLine();
                while (!line.equals("steps:")) {
                    if (rec == 0) ing++;
                    line = reader.readLine();
                }

                int count = 1;
                line = reader.readLine();
                while (line != null && !line.equals("")) {
                    if (rec == 0) steps++;
                    line = reader.readLine();
                    count++;
                }
                rec++;
            }
            result = new Recipe(name, ing, steps);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    static void thirdExercise() {
        try {
            FileInputStream input = new FileInputStream("/home/eduardo/IdeaProjects/JavaAndroid/src/exercises/lesson3/favorite_recipe.txt");
            ObjectInputStream inputStream = new ObjectInputStream(input);

            Recipe myRecipe = (Recipe) inputStream.readObject();

            System.out.println(myRecipe.getName());
            System.out.println("ingredients: " + myRecipe.getIngredients());
            System.out.println("steps: " + myRecipe.getSteps());
        } catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String getIndentation(int indent) {
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < indent; i++) {
            builder.append("\t");
        }
        return builder.toString();
    }
}
