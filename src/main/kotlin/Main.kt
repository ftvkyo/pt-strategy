import Controller.Controller
import Model.Model
import View.InterfaceDescription.ViewDescription
import View.View
import com.google.gson.Gson
import java.io.*


class Main {

    companion object {

        @JvmStatic fun main(args: Array<String>) {

            val g = Gson()

            val classLoader = javaClass.classLoader
            val file = File(classLoader.getResource("View/ViewDescription.json").file)
            var reader: BufferedReader? = null
            var interfaceDescription = ViewDescription()

            try {
                reader = BufferedReader(FileReader(file))

                interfaceDescription = g.fromJson(reader.readText(), ViewDescription::class.java)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                try {
                    if (reader != null) {
                        reader.close()
                    }
                } catch (e: IOException) {}
            }


            Renderer.init()

            Renderer(interfaceDescription.internalWidth,
                    interfaceDescription.internalHeight).use { renderer: Renderer ->
                val model = Model()
                val controller = Controller()
                val view = View(controller, interfaceDescription)

                renderer.setView(view)
                renderer.setController(controller)

                controller.setModel(model)
                model.setReceiver(view)

                renderer.run()
            }


            Renderer.finish()
        }
    }
}
