#namespace("user")
    #sql("getUserByName")
        SELECT * FROM user WHERE name = #p(name);
    #end

    #sql("addUser")
        INSERT INTO user(name, password) VALUES (#p(name), #p(password))));
    #end
#end