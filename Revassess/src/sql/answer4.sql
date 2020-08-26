select category_id, question, answer, username from flashcard, app_user
inner join study_set_card ssc on flashcard_id = flashcard_id
inner join study_set ss on ssc.study_set_id = ss.study_set_id where owner_id =  5;
