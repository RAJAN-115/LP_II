def dfs(v):
    visited[v] = True
    print(v, end=" ")  # Print the visited vertex

    for w in adjacency_list[v]:
        if not visited[w]:
            dfs(w)

num_vertices = int(input("Enter the number of vertices: "))
num_edges = int(input("Enter the number of edges: "))

visited = [False] * num_vertices
adjacency_list = [[] for _ in range(num_vertices)]

print("Enter the edges (u v):")
for _ in range(num_edges):
    u, v = map(int, input().split())
    adjacency_list[u].append(v)
    adjacency_list[v].append(u)  # Remove this line for a directed graph

start_vertex = int(input("Enter the starting vertex: "))

print("DFS traversal starting from vertex", start_vertex, ": ", end="")
dfs(start_vertex)
