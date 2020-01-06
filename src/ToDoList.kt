import java.lang.StringBuilder
import java.util.ArrayList

/**
 * Created by User on 05 Янв., 2020
 */
internal class ToDoList {
    private var tasks: ArrayList<String> = ArrayList()


    fun add(index: Int, element: String){
        tasks.add(index, element)
    }

    fun add(element: String){
        tasks.add(element)
    }

    fun list(): String{
        val builder = StringBuilder();
        for (i in 0..tasks.size - 1){
            builder.append(String.format("%3d - %s\n", i, tasks.get(i)))
        }
        return builder.toString();
    }

    fun edit(index: Int, element: String){
        tasks.set(index, element)
    }

    fun delete(index: Int){
        if (index >= tasks.size)
        tasks.removeAt(index)
    }
}



//LIST должен выводить дела с их порядковыми номерами.
//ADD - добавлять дело в конец списка или дело на определённое место,
//  сдвигая остальные дела вперёд, если указать номер.
//EDIT - заменять дело с указанным номером.
//DELETE - удалять.