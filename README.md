## About The Project

This is a CLI shell project that will help you to manage and store you students!

### Built With
- SPRING
- GRADLE
- SPRING SHELL

### Installation

Just build and run this spring application as usual.

### CLI commands
All interaction provided by CLI commands:
- Adding new student. Format should match pattern.
    ```
    add --f {first name} --l {last name} --a {age}
    ```
- Remove student by id. You can find needed id using command list.
    ```
    delete --id {id}
    ```
- Presentation of full list of students.
    ```
    list
    ```
- Clean students storage.
    ```
    clean
    ```

## Usage

The application can initialize starting storage of students list wia csv. To do this, you need to following:
- Prepare file with format {firstName};{lastName}. Example of that file located at src/main/resources/students.csv.
- Enable initialization in properties. Use property app.student-initializer.enabled with true/false value. 
- Set path to csv file in properties. Use property initial.students.file.path

## Docker
Make sure to disable initialization, it would not work with it.
1. Start docker on your pc
2. Build image
    ```
    docker build -t student-server .
    ```
3 run container
    ```
    docker run -it --rm student-server
    ```
    Now you can use shall as usual.
4 Exit. If you want to exit, just type
    ```
    docker run -it --rm student-server
    ```





   


