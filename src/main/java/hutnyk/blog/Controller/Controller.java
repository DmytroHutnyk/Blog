package hutnyk.blog.Controller;

import hutnyk.blog.Model.DTO.BlogDTO;
import hutnyk.blog.Model.DTO.RoleDTO;
import hutnyk.blog.Model.DTO.UserDTO;
import hutnyk.blog.Service.ArticleService;
import hutnyk.blog.Service.BlogService;
import hutnyk.blog.Service.RoleService;
import hutnyk.blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import hutnyk.blog.Model.DTO.ArticleDTO;

import java.util.*;

@org.springframework.stereotype.Controller
public class Controller {

    private final ArticleService articleService;
    private final UserService userService;
    private final RoleService roleService;
    private final BlogService blogService;
    private final ApplicationContext context;

    @Autowired
    public Controller(ArticleService articleService, UserService userService,
                                 RoleService roleService, BlogService blogService,
                                 ApplicationContext context) {
        this.articleService = articleService;
        this.userService = userService;
        this.roleService = roleService;
        this.blogService = blogService;
        this.context = context;
    }

    public void startApplication() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("Select an option: \n" +
                    "1. Manage Articles \n" +
                    "2. Manage Users \n" +
                    "3. Manage Roles \n" +
                    "4. Manage Blogs \n" +
                    "5. Exit application: \n");

            int option = scanInt(scanner);

            switch (option) {
                case 1 -> manageArticles(scanner);
                case 2 -> manageUsers(scanner);
                case 3 -> manageRoles(scanner);
                case 4 -> manageBlogs(scanner);
                case 5 -> {
                    isRunning = false;
                    System.out.println("Exiting application...");
                    SpringApplication.exit(context, () -> 0);
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void manageArticles(Scanner scanner) {
        boolean backToMain = false;
        while (!backToMain) {
            System.out.println("Article Management: \n" +
                    "1. View All Articles \n" +
                    "2. Add Article \n" +
                    "3. Find Article by ID \n" +
                    "4. Delete Article by ID \n" +
                    "5. Back to Main Menu \n");


            int option = scanInt(scanner);

            switch (option) {
                case 1 -> articleService.findAllArticles().forEach(System.out::println);
                case 2 -> addArticle(scanner);
                case 3 -> findArticleById(scanner);
                case 4 -> deleteArticleById(scanner);
                case 5 -> backToMain = true;
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void addArticle(Scanner scanner) {
        System.out.println("Enter Article Title:");
        String title = scanner.nextLine();

        System.out.println("Enter User ID:");
        Long userId = scanLong(scanner);

        System.out.println("Enter Blog ID:");
        Long blogId = scanLong(scanner);

        ArticleDTO articleDTO = new ArticleDTO(title, userId, blogId);
        articleService.addArticle(articleDTO);
        System.out.println("Article added successfully.");
    }

    private void findArticleById(Scanner scanner) {
        System.out.println("Enter Article ID:");
        Long id = scanLong(scanner);

        try {
            System.out.println(articleService.findArticleById(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteArticleById(Scanner scanner) {
        System.out.println("Enter Article ID:");
        Long id = scanLong(scanner);

        try {
            articleService.deleteArticleById(id);
            System.out.println("Article deleted successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void manageUsers(Scanner scanner) {
        boolean backToMain = false;
        while (!backToMain) {
            System.out.println("User Management: \n" +
                    "1. View All Users \n" +
                    "2. Add User \n" +
                    "3. Find User by ID \n" +
                    "4. Find User by Email \n" +
                    "5. Delete User by ID \n" +
                    "6. Back to Main Menu \n");


            int option = scanInt(scanner);

            switch (option) {
                case 1 -> userService.getAllUsers().forEach(System.out::println);
                case 2 -> addUser(scanner);
                case 3 -> findUserById(scanner);
                case 4 -> findUserByEmail(scanner);
                case 5 -> deleteUserById(scanner);
                case 6 -> backToMain = true;
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void addUser(Scanner scanner) {
        System.out.println("Enter User Email:");

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        String email = scanner.nextLine();

        System.out.println("Enter Blog ID:");
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        Long blogId = scanLong(scanner);

        System.out.println("Enter Role IDs (comma-separated):");
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }


        List<Long> roleIds = scanLongList(scanner);

        UserDTO userDTO = new UserDTO(email, new ArrayList<>(), blogId, roleIds);
        userService.addUser(userDTO);
        System.out.println("User added successfully.");
    }

    private void findUserById(Scanner scanner) {
        System.out.println("Enter User ID:");
        Long id = scanLong(scanner);

        try {
            System.out.println(userService.findUserById(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findUserByEmail(Scanner scanner) {
        System.out.println("Enter User Email:");

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        String email = scanner.nextLine();

        try {
            System.out.println(userService.findUserByEmail(email));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteUserById(Scanner scanner) {
        System.out.println("Enter User ID:");
        Long id = scanLong(scanner);

        try {
            userService.deleteUserById(id);
            System.out.println("User deleted successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void manageRoles(Scanner scanner) {
        boolean backToMain = false;
        while (!backToMain) {
            System.out.println("Role Management: \n" +
                    "1. View All Roles \n" +
                    "2. Add Role \n" +
                    "3. Find Role by ID \n" +
                    "4. Find Role by Name \n" +
                    "5. Delete Role by ID \n" +
                    "6. Back to Main Menu \n");


            int option = scanInt(scanner);

            switch (option) {
                case 1 -> roleService.getAllRoles().forEach(System.out::println);
                case 2 -> addRole(scanner);
                case 3 -> findRoleById(scanner);
                case 4 -> findRoleByName(scanner);
                case 5 -> deleteRoleById(scanner);
                case 6 -> backToMain = true;
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void addRole(Scanner scanner) {
        System.out.println("Enter Role Name:");
        String name = scanner.nextLine();

        System.out.println("Enter User IDs (comma-separated):");
        List<Long> userIds = scanLongList(scanner);

        RoleDTO roleDTO = new RoleDTO(name, userIds);
        roleService.addRole(roleDTO);
        System.out.println("Role added successfully.");
    }

    private void findRoleById(Scanner scanner) {
        System.out.println("Enter Role ID:");
        Long id = scanLong(scanner);

        try {
            System.out.println(roleService.findRoleById(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findRoleByName(Scanner scanner) {
        System.out.println("Enter Role Name:");
        String name = scanner.nextLine();

        try {
            System.out.println(roleService.findRoleByName(name));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteRoleById(Scanner scanner) {
        System.out.println("Enter Role ID:");
        Long id = scanLong(scanner);

        try {
            roleService.deleteRoleById(id);
            System.out.println("Role deleted successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private void manageBlogs(Scanner scanner) {
        boolean backToMain = false;
        while (!backToMain) {
            System.out.println("Blog Management: \n" +
                    "1. View All Blogs \n" +
                    "2. Add Blog \n" +
                    "3. Find Blog by ID \n" +
                    "4. Find Blog by Name \n" +
                    "5. Delete Blog by ID \n" +
                    "6. Back to Main Menu \n");


            int option = scanInt(scanner);

            switch (option) {
                case 1 -> blogService.getAllBlogs().forEach(System.out::println);
                case 2 -> addBlog(scanner);
                case 3 -> findBlogById(scanner);
                case 4 -> findBlogByName(scanner);
                case 5 -> deleteBlogById(scanner);
                case 6 -> backToMain = true;
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void addBlog(Scanner scanner) {
        System.out.println("Enter Blog Name:");
        String name = scanner.nextLine();

        System.out.println("Enter User ID:");
        Long userId = scanLong(scanner);

        System.out.println("Enter Article IDs (comma-separated):");
        List<Long> articleIds = scanLongList(scanner);

        BlogDTO blogDTO = new BlogDTO(name, articleIds, userId);
        blogService.addBlog(blogDTO);
        System.out.println("Blog added successfully.");
    }

    private void findBlogById(Scanner scanner) {
        System.out.println("Enter Blog ID:");
        Long id = scanLong(scanner);

        try {
            System.out.println(blogService.findBlogById(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findBlogByName(Scanner scanner) {
        System.out.println("Enter Blog Name:");
        String name = scanner.nextLine();

        try {
            System.out.println(blogService.findBlogByName(name));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteBlogById(Scanner scanner) {
        System.out.println("Enter Blog ID:");
        Long id = scanLong(scanner);

        try {
            blogService.deleteBlogById(id);
            System.out.println("Blog deleted successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private int scanInt(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please enter a number.");
            scanner.nextLine();
            return -1;
        }
    }

    private Long scanLong(Scanner scanner) {
        try {
            return scanner.nextLong();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please enter a valid number.");
            scanner.nextLine();
            return -1L;
        }
    }

    private List<Long> scanLongList(Scanner scanner) {
        String input = scanner.nextLine();
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Long::parseLong)
                    .toList();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please enter valid IDs separated by commas.");
            return new ArrayList<>();
        }
    }
}
