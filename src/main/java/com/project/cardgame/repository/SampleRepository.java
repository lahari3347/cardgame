package com.project.cardgame.repository;

public interface SampleRepository {
    // read about jpa (java persistence api) here => https://medium.com/@serxanhamzayev/spring-data-jpa-a-hands-on-approach-to-modern-data-management-86ed96774816
    // this is used to make repository queries using internal implementations meaning you dont have to write sql / any query to to basic jobs.
    /*
    * for example:
    * consider there is a table called friends which has columns {name, company_placed, phone_no, email}
    * you can fetch any record by any column with this simple query, assuming we have a sql database in place
    * => findByName("lahari") will give you the record which has record name as lahari
    * this is equivalent to MYSql as `select * from friends where name="lahari"`
    * */

    // todos
    // read more about JPA and JPA repository
    // learn / study how to use repository interface(s) for our use case, either mysql or mongo
    // come up with connection mechanisms by reading blogs and referring youtube tutorials
    // this is basically how do we create a db in local and use that to connect


    // SQL reference: https://dev.mysql.com/doc/refman/5.7/en/built-in-function-reference.html
    //

}
