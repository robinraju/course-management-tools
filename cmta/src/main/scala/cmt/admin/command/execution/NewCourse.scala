package cmt.admin.command.execution

import cmt.admin.command.AdminCommand.NewCourse
import cmt.core.execution.Executable

given Executable[NewCourse] with
  extension (cmd: NewCourse)
    def execute(): Either[String, String] = {
      println(s"creating a new course called '${cmd.courseName.value}'")
      Right("")
    }
