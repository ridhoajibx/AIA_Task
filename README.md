# Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Overal Structure

### Details

```
1. make sure the source folder you want to move.
2. read all files in the source folder by looping.
3. do filtering extensions before moving each file in the forder, which is only PDF and excel extensions.
4. then moves files from the source folder to the target folder
```


### Method name

```
listFilesForFolder
```

Function is to read all the files in the source folder, this will need (File folder) as data type from main thread.

```
moveFile
```

Function is to move files, this will need (listfiles) from FileEntry. then do the filtering extensions using endsWith to the target folder, namely the DestPath folder, and logger.info is done every time the file is moved

