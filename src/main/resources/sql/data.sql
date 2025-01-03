-- Insert data into blog table
INSERT INTO blog (id, name) VALUES
    (1, 'Tech Trends'),
(2, 'Travel Diaries'),
(3, 'Foodies Paradise'),
(4, 'Fitness World'),
(5, 'Finance Insights'),
(6, 'Artistic Minds'),
(7, 'Movie Buffs'),
(8, 'Gadget Reviews'),
(9, 'Gaming Arena'),
(10, 'Educational Hub');

-- Insert data into users table
INSERT INTO users (id, email, blog_id) VALUES
    (1, 'admin@example.com', 1),
(2, 'editor@example.com', 2),
(3, 'viewer@example.com', 3),
(4, 'contributor@example.com', 4),
(5, 'manager@example.com', 5),
(6, 'analyst@example.com', 6),
(7, 'moderator@example.com', 7),
(8, 'developer@example.com', 8),
(9, 'designer@example.com', 9),
(10, 'tester@example.com', 10);

-- Insert data into role table
INSERT INTO role (id, name) VALUES
    (1, 'Admin'),
(2, 'Editor'),
(3, 'Viewer'),
(4, 'Contributor'),
(5, 'Manager'),
(6, 'Analyst'),
(7, 'Moderator'),
(8, 'Developer'),
(9, 'Designer'),
(10, 'Tester');

-- Insert data into user_role table
INSERT INTO user_role (user_id, role_id) VALUES
    (1, 1), (1, 5),
    (2, 2), (2, 6),
    (3, 3),
    (4, 4), (4, 7),
    (5, 5), (5, 8),
    (6, 6),
    (7, 7),
    (8, 8),
    (9, 9),
    (10, 10);

-- Insert data into article table
INSERT INTO article (id, title, user_id, blog_id) VALUES
    (1, 'Top Tech Trends 2024', 1, 1),
(2, 'AI: The Future of Innovation', 1, 1),
(3, 'Cybersecurity Tips for Businesses', 1, 1),
(4, 'Traveling Europe on a Budget', 2, 2),
(5, 'Hidden Gems of Asia', 2, 2),
(6, '10 Best Recipes for Beginners', 3, 3),
(7, 'How to Make Sourdough Bread', 3, 3),
(8, '5 Exercises for a Strong Core', 4, 4),
(9, 'Yoga for Beginners', 4, 4),
(10, 'Investing in Stocks 101', 5, 5),
(11, 'Cryptocurrency Myths Debunked', 5, 5),
(12, 'Creative Art Projects', 6, 6),
(13, 'Exploring Watercolor Techniques', 6, 6),
(14, 'Upcoming Movies to Watch', 7, 7),
(15, 'Top 10 Movie Franchises of All Time', 7, 7),
(16, 'Review of the Latest iPhone', 8, 8),
(17, 'Top 5 Android Phones of 2024', 8, 8),
(18, 'Top 10 Video Games of 2024', 9, 9),
(19, 'E-Sports: The Next Big Thing', 9, 9),
(20, 'Learning Java Programming', 10, 10),
(21, 'Introduction to Machine Learning', 10, 10);

INSERT INTO article (id, title, user_id, blog_id) VALUES
    (22, 'Tech for Green Energy', 1, 1),
(23, 'Adventures in South America', 2, 2),
(24, 'Cooking with Seasonal Ingredients', 3, 3),
(25, 'Building Your Home Gym', 4, 4),
(26, 'Beginner’s Guide to Mutual Funds', 5, 5),
(27, 'The History of Modern Art', 6, 6),
(28, 'Horror Movies to Watch This Halloween', 7, 7),
(29, 'The Future of Mobile Gaming', 9, 9);

INSERT INTO user_role (user_id, role_id) VALUES
    (1, 8),
(2, 3),
(3, 7),
(4, 9);
