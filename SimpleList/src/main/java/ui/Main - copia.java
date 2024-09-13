// Para implementar este sistema en Java con listas enlazadas, puedes seguir este enfoque:

// Crear las clases necesarias:

// Product: Clase que representa un producto con atributos como nombre, precio y cantidad.
// OrderList: Clase para la lista enlazada que gestiona los pedidos. Esta contendrá nodos que representan productos.
// Node: Clase que representa un nodo de la lista enlazada.
// Leer el archivo inventario.json: Usar la biblioteca org.json para cargar los productos desde un archivo JSON.

// Agregar productos a la lista de pedidos: Implementar un método para agregar un nodo a la lista enlazada.

// Buscar productos en la lista de pedidos: Implementar un método que permita buscar un producto por nombre, precio o cantidad.

// Imprimir la lista de pedidos: Implementar un método que imprima el estado de la lista en el formato adecuado.

// Aquí te dejo un código básico para lograr esto:

// Clases
// Clase Product
// java
// Copy code
// public class Product {
//     private String name;
//     private double price;
//     private int quantity;

//     public Product(String name, double price, int quantity) {
//         this.name = name;
//         this.price = price;
//         this.quantity = quantity;
//     }

//     public String getName() {
//         return name;
//     }

//     public double getPrice() {
//         return price;
//     }

//     public int getQuantity() {
//         return quantity;
//     }

//     @Override
//     public String toString() {
//         return "(" + name + ", $" + price + ", " + quantity + ")";
//     }
// }
// Clase Node
// java
// Copy code
// public class Node {
//     Product product;
//     Node next;

//     public Node(Product product) {
//         this.product = product;
//         this.next = null;
//     }
// }
// Clase OrderList
// java
// Copy code
// public class OrderList {
//     private Node head;

//     // Constructor
//     public OrderList() {
//         this.head = null;
//     }

//     // Agregar producto a la lista de pedidos
//     public void addProduct(Product product) {
//         Node newNode = new Node(product);
//         if (head == null) {
//             head = newNode;
//         } else {
//             Node current = head;
//             while (current.next != null) {
//                 current = current.next;
//             }
//             current.next = newNode;
//         }
//     }

//     // Buscar producto por nombre
//     public boolean searchProduct(String name) {
//         Node current = head;
//         while (current != null) {
//             if (current.product.getName().equalsIgnoreCase(name)) {
//                 return true;
//             }
//             current = current.next;
//         }
//         return false;
//     }

//     // Imprimir la lista de pedidos
//     public void printOrderList() {
//         Node current = head;
//         while (current != null) {
//             System.out.print(current.product);
//             if (current.next != null) {
//                 System.out.print(" → ");
//             }
//             current = current.next;
//         }
//         System.out.println();
//     }
// }
// Lectura del archivo JSON
// Usa la biblioteca org.json para leer el archivo inventario.json. Aquí tienes un ejemplo básico de cómo podrías cargarlo:

// Dependencia Maven para JSON
// xml
// Copy code
// <dependency>
//     <groupId>org.json</groupId>
//     <artifactId>json</artifactId>
//     <version>20230227</version>
// </dependency>
// Clase para cargar productos desde el archivo JSON
// java
// Copy code
// import org.json.JSONArray;
// import org.json.JSONObject;

// import java.io.FileReader;
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Paths;

// public class InventoryLoader {

//     public static void loadInventory(String filePath, OrderList orderList) {
//         try {
//             String content = new String(Files.readAllBytes(Paths.get(filePath)));
//             JSONArray productsArray = new JSONArray(content);

//             for (int i = 0; i < productsArray.length(); i++) {
//                 JSONObject productObj = productsArray.getJSONObject(i);
//                 String name = productObj.getString("Producto");
//                 double price = productObj.getDouble("Precio");
//                 int quantity = productObj.getInt("Cantidad");

//                 Product product = new Product(name, price, quantity);
//                 orderList.addProduct(product);
//             }

//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }
// Ejemplo de uso
// java
// Copy code
// public class Main {
//     public static void main(String[] args) {
//         OrderList orderList = new OrderList();

//         // Cargar el inventario desde el archivo JSON
//         InventoryLoader.loadInventory("inventario.json", orderList);

//         // Agregar un nuevo producto
//         Product newProduct = new Product("Laptop", 5800000, 10);
//         orderList.addProduct(newProduct);

//         // Buscar un producto
//         boolean found = orderList.searchProduct("Laptop");
//         System.out.println("Producto encontrado: " + found);

//         // Imprimir la lista de pedidos
//         orderList.printOrderList();
//     }
// }
// Formato de salida:
// bash
// Copy code
// (Laptop, $5800000.0, 10) → (Smartphone, $4499999.0, 40) → ...
// Con este código puedes cargar productos desde un archivo JSON, agregarlos a una lista de pedidos, buscar productos y mostrar la lista en consola.