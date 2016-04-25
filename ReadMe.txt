1. A main zip file is created with all subfolders of all the variants of the prims,kruskal's algorithm. The main project code is in the folder called 'algos'.

2.Open eclipse > right click in package explorer section > click on import > expand General > Existing projects into workspace.

3.When import is done,the project will have errors. For removing the errors, we have to add jar manually. This can be done by following these steps.

	right click on the project > Properties > Java Build Path > libraries tab > remove the commons-collections-2.1.1.jar in the list > Add External Jars > Navigate to the path where commons-collections-2.1.1.jar is located and add it.

4. Now we give the url of the input file as the first argument and output file as the second argument (each is separated by space).

5. Prim's and kruskal's algorithms should be opened using packages "com.prims" and "kruskal" respectively.

6. Open the java files in the project and execute them using all the input files provided in "input_files" folder.

7. The input is in the format <node_id, x_coordinate, y_coordinate> preceded by the number of nodes. The program calculates the edge cost by calculating the euclidean distance between the nodes.