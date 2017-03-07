#namespace("user")
    #sql("getUserByName")
        SELECT * FROM user WHERE name = #p(name);
    #end
#end