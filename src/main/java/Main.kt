import Controller.Controller
import Model.Model
import View.View

fun main(args: Array<String>){
    Renderer.init()

    Renderer().use { renderer: Renderer ->
        val model = Model()
        val view = View(Renderer.windowWidth.toFloat(), Renderer.windowHeight.toFloat())
        val controller = Controller()

        renderer.setView(view)
        renderer.setController(controller)

        controller.setModel(model)
        view.setController(controller)
        model.setReceiver(view)

        renderer.run()
    }


    Renderer.finish()
}
