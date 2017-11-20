   document.getElementById('confirm').onclick = function() {
    	  return confirm('Are you sure?');
      }; 
      var homePage = document.querySelector('.random article');
  	homePage.addEventListener('mouseover',function(){ 
  		this.style.fontSize = '40px';
  			});
  	homePage.addEventListener('mouseout',function(){
  	this.style.fontSize = '20px';
  	});
  	var footer = document.querySelector('.copy__right p');

    copyrightText.addEventListener('click', function(){
      if(this.innerText !== 'Created by: Yesharge Abrha'){
        this.innerText = 'Created by: Yesharge Abrha'
      }
    });
    function myFunction() {
		var reply =	document.getElementById('comment_id').value;
		document.getElementById('comment').innerText = reply;
	};