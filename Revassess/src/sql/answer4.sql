select au.username as "au.username", f.question as "f.question", f.answer as "f.answer", f.category_id as "f.category_id" 
from flashcard f, study_set_card ssc, study_set ss, app_user au  
where f.flashcard_id = ssc.flashcard_id 
and ssc.study_set_id = ss.study_set_id 
and ss.owner_id = au.user_id and au.user_id = 5;