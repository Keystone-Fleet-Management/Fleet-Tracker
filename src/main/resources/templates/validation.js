
    window.addEventListener("load", function() {
       let form = document.querySelector("form");
      //  console.log ("test");
       let btn =  document.querySelector("button [id=btn]");
       btn.addEventListener("click", function(event) {
          
          //declair name phone start end date
          let name = document.querySelector("input[name=name]");
          let phone = document.querySelector("input[name=phone]");
          let start = document.querySelector("input[name=start]");
          let end = document.querySelector("input[name=end]");
          let date = document.querySelector("input[name=date]");
 
          // function to determin if a box is unfilled alert user of requirements
          
          if (name.value === "") {
             alert("Name field required!");
                event.preventDefault()
          };
                       
             if (phone.value === ""|| isNaN(phone.value) ) {
             alert("Phone field required/has invalide characters");
              event.preventDefault();
             };
 
              if (start.value === "") {
             alert("Start field required!");
                event.preventDefault();
             };
 
                if (end.value === "") {
             alert("End field required!");
                event.preventDefault();
             };
 
                if (date.value === "") {
             alert("Date field required!");
                event.preventDefault();
             };
        
 
             //Submission recognized
             
             let form = document.querySelector("form");
          form.addEventListener("submit", function(event) {
             alert("Form Submit!");
          });
 
       });
    });