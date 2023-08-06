# **AN14-onl** :iphone: **/ Homeworks** :books:
#### Here I will publish the solved tasks for the Android App Development course
![Java](https://img.shields.io/badge/java-%23ED8B00?style=for-the-badge&logo=coffeescript&logoColor=white) ![Kotlin](https://img.shields.io/badge/Kotlin-blueviolet?style=for-the-badge&logo=Kotlin&logoColor=blue) ![Android](https://img.shields.io/badge/Android-green?style=for-the-badge&logo=android&logoColor=black) ![IntelliJ](https://img.shields.io/badge/IntelliJ_IDEA-black?style=for-the-badge&logo=intellijidea&logoColor=white) 
___
### The last homework :
[![Homework](https://icons.iconarchive.com/icons/papirus-team/papirus-places/256/folder-yellow-java-icon.png "Go to directory")](src/ProblemOfSquares)

### Task: 

#### **Given a two-dimensional array of ints, consisting of 0 and 1.**
#### **Find the maximum number of squares that can be made from 1.**
Example:
``` java
In
1 0 1 1
1 0 1 1
1 0 1 1
1 0 1 1
1 0 1 1
```
``` java
Out
19
```

### Solution Code

``` java
 public static Integer countSquare(int[][] matrix) {
    int result = 0;
    
    for(int i = 0; i < matrix.length; ++i) {
        for(int j = 0; j < matrix[i].length; ++j) {
    
            if(matrix[i][j] == 1) {
                ++result;
                int maxSize = Math.min(matrix[i].length - j, matrix.length - i);
    
                //Пока возможен квадрат большего размера
                for (int counter = 1; counter < maxSize; ++counter, ++result){
    
                    //Проверяем соседние элементы снизу и справа
                    for(int k = 0; k < counter; ++k){
                        if (matrix[i + counter][j+k] != 1 || matrix[i+k][j + counter] != 1) {
                            counter = 0;
                            break;
                        }
                    }
    
                    //Если в соседняя или диоганальная клетка равна 0 - останавливаем цикл
                    if (counter == 0 || matrix[i + counter][j + counter] != 1){
                        break;
                    }
                }
            }
        }
    }
    
    return result;
 }
```