# 📜 Duke Project User Guide

<pre>
    ____        _        
   |  _ \ _   _| | _____ 
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
</pre>

_Duke_ is a CLI Chatbot that helps a person to keep track of various things.

<!-- Table of Content -->

- [Quick Start](#quick-start)
- [Features](#features)
  - [ADDING A TASK](#adding-a-task)
    - [Todo Tasks: `todo`](#1-todo-tasks-todo)
    - [Deadline Tasks: `deadline`](#2-deadline-tasks-deadline)
    - [Event Tasks: `event`](#3-event-tasks-event)
  - [GENERAL COMMANDS](#general-commands)
    - [Show full lists of tasks: `list`](#1-show-full-lists-of-tasks-list)
    - [Find all tasks containing keyword(s): `find`](#2-find-all-tasks-containing-keywords-find)
    - [Mark task as done: `mark`](#3-mark-task-as-done-mark)
    - [Unmark task as done: `unmark`](#4-unmark-task-as-done-unmark)
    - [Deleting a task: `delete`](#5-deleting-a-task-delete)
    - [Getting full list of commands: `help`](#6-getting-full-list-of-commands-help)
    - [Exit programme: `bye`](#7-exit-programme-bye)
- [Command Summary](#command-summary)

## Quick Start

1. Ensure you have Java 11 or above installed on your Computer.
2. Update Intellij to the most recent version
3. Download the latest ip.jar from here.
4. Copy the file to the desired folder as the home folder for the program.
5. Open the command terminal, cd into the home folder of the program and use command `java -jar ip.jar` to run the application.

## Features

### ADDING A TASK:

#### There are 3 ways to add an entry depending on the type of your task

### 1. Todo Tasks: `todo`

      todo TASK_DESCRIPTION

      EXAMPLE: todo CS2113 Coursemology

Expected Outcome:<br/>

`Got it. I've added this task:` <br/>
`[T][ ] CS2113 Coursemology` <br/>
`Now you have 1 tasks in the list.`

### 2. Deadline Tasks: `deadline`

      deadline TASK_DESCRIPTION /by DEADLINE_DESCRIPTION

      EXAMPLE: deadline complete this week's IP /by Wednesday

Expected Outcome:<br/>
`Got it. I've added this task:` <br/>
`[D][ ] complete this week's IP (by: Wednesday)` <br/>
`Now you have 1 tasks in the list.`

### 3. Event Tasks: `event`

      event TASK_DESCRIPTION /from START_PERIOD /to END_PERIOD

      EXAMPLE: event project meeting /from Mon 2pm /to 4pm

Expected Outcome:<br/>
`Got it. I've added this task:` <br/>
`[E][ ] project meeting (from: Mon 2pm to: 4pm)` <br/>
`Now you have 1 tasks in the list.`

### GENERAL COMMANDS:

### 1. Show full lists of tasks: `list`

      show list of all tasks

      Example: list

Expected Outcome:<br/>
`Here are the tasks in your list:` <br/>
`1.[T][] CS2113 Coursemology`<br/>
`2.[D][X] submit EE2026 assignment (by: June 6th)`<br/>
`3.[E][X] project meeting (from: Aug 6th 2 to: 4pm)`<br/>
`4.[T][ ] CG2023 Lab homework`<br/>

### 2. Find all tasks containing keyword(s): `find`

      find KEYWORDS

      EXAMPLE: find book

Expected Outcome:<br/>
`Here are the matching tasks in your list:`<br/>
`1.[T][X] read book`<br/>
`2.[D][X] return book (by: June 6th)`<br/>
`5.[D][X] return book (by: Sunday)`

### 3. Mark task as done: `mark`

      mark TASK_NUMBER

      EXAMPLE: mark 1

Expected Outcome:<br/>
`Nice! I've marked this task as done:`<br/>
`[T][X] CS2113 Coursemology`

### 4. Unmark task as done: `unmark`

      unmark TASK_NUMBER

      EXAMPLE: unmark 4

Expected Outcome:<br/>
`OK, I've marked this task as not done yet:`<br/>
`[E][ ] project meeting (from: Aug 6th 2 to: 4pm)`

### 5. Deleting a task: `delete`

      delete TASK_NUMBER

      EXAMPLE: delete 5

Expected Outcome:<br/>
`Noted. I've removed this task:`<br/>
`Now you have 3 tasks in the list.`

### 6. Getting full list of commands: `help`

      help

      EXAMPLE: help

Expected Outcome:<br/>
`Noted. I've removed this task:`<br/>
`Now you have 3 tasks in the list.`
`Welcome to the help desk! Here are a list of commands that you can input:`<br/>
`GENERAL COMMANDS:`<br/>
`1. list ->`<br/>
`lists the tasks in your list.`<br/>
`2. find 'XXXX' ->`<br/>
`find XXXX from all tasks, and lists them.`<br/>
`3. mark X ->`<br/>
`marks the task at position X as 'done'.`<br/>
`4. unmark X ->`<br/>
`unmarks the task at position X as 'undone'.`<br/>
`5. delete X ->`<br/>
`deletes the task at position X.`<br/>
`6. bye ->`<br/>
`exits the application.`<br/>

`ADDING TASKS:`<br/>
`1. todo 'XXXX'`<br/>
`adds a new todo task XXXX to the list.`<br/>
`2. deadline 'XXXX' /by 'YYYY' ->`<br/>
`adds a task with a deadline, with XXXX being the task and YYYY being the deadline.`<br/>
`3. event 'XXXX' /from 'YYYY' /to 'ZZZZ'`<br/>
`adds an event, with XXXX as the event name, YYYY as the start date, and ZZZZ as the end date.`<br/>

### 7. Exit programme: `bye`

      exits the programme

      Example: bye

Expected Outcome:<br/>
`Bye. Hope to see you again soon!`<br/>

## Command Summary

| Action            | Format, Examples                                                                                                |
| ----------------- | --------------------------------------------------------------------------------------------------------------- |
| Add Todo task     | todo TASK_DESCRIPTION<br/>`E.g. todo borrow book`                                                               |
| Add Deadline task | deadline TASK_DESCRIPTION /by DATE<br/>`E.g. deadline return book /by Sunday`                                   |
| Add Event task    | event TASK_DESCRIPTION /from START_PERIOD /to END_PERIOD<br/>`E.g. event project meeting /from Mon 2pm /to 4pm` |
| List              | list<br/>`E.g. list`                                                                                            |
| Find              | find KEYWORDS<br/>`E.g. find book`                                                                              |
| Mark task         | mark TASK_NUMBER<br/>`E.g. mark 1`                                                                              |
| Unmark task       | unmark TASK_NUMBER<br/>`E.g. unmark 4`                                                                          |
| Delete            | delete TASK_NUMBER<br/>`E.g. delete 5`                                                                          |
| Help              | help<br/>`E.g.help'                                                                                             |
| Exit              | bye<br/>`E.g. bye`                                                                                              |
