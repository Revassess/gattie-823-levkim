select * from study_set 
full outer join app_user on study_set.owner_id = app_user.user_id where app_user.user_id = 5;
