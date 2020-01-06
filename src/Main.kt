/**
 * Created by User on 05 Янв., 2020
 */


fun main(args: Array<String>) {
    val commandList = "LIST"
    val commandAdd = "ADD"
    val commandEdit = "EDIT"
    val commandDelete = "DELETE"
    val commandExit = "exit"
    val taskList = ToDoList()
    do {
        val inline = readLine()
        if (inline != null) {
            val strings = inline.split("\\s".toRegex())
            if ((strings.size == 1) and (strings.get(0).equals(commandList))) {
                println(taskList.list())
            } else if (strings.size == 2) {
                if (strings.get(0).equals(commandDelete)) {
                    val index = strings.get(1).toIntOrNull()
                    if (index != null) {
                        taskList.delete(index)
                    }
                } else if (strings.get(0).equals(commandAdd)) {
                    taskList.add(strings.get(1))
                }
            } else if (strings.size == 3) {
                val index = strings.get(1).toIntOrNull()
                if (index != null) {
                    if (strings.get(0).equals(commandAdd)) {
                        taskList.add(index, strings.get(2))
                    }
                    if (strings.get(0).equals(commandEdit)) {
                        taskList.edit(index, strings.get(2))
                    }
                }
            } else println("Invalid format")
        }

    } while (!inline.equals(commandExit) or (inline == null))
}


//LIST должен выводить дела с их порядковыми номерами.
//ADD - добавлять дело в конец списка или дело на определённое место,
//  сдвигая остальные дела вперёд, если указать номер.
//EDIT - заменять дело с указанным номером.
//DELETE - удалять.
//
//Примеры команд:
//LIST
//ADD Какое-то дело
//ADD 4 Какое-то дело на четвёртом месте
//EDIT 3 Новое название дела
//DELETE 7