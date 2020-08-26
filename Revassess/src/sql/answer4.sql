select au.username, question, answer, category_id from flashcard f 
inner join study_set_card ssc on ssc.flashcard_id = f.flashcard_id 
inner join study_set ss on ss.study_set_id = ssc.study_set_id 
inner join app_user au on owner_id = user_id where user_id = 5;