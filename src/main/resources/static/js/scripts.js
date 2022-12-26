//upload photo//////////////////////////////////////////////
$(document).ready(() => {
    $("#photo").change(function () {
        const file = this.files[0];
        if (file) {
            let reader = new FileReader();
            reader.onload = function (event) {
                $("#imgPreview")
                    .attr("src", event.target.result);
            };
            reader.readAsDataURL(file);
        }
    });
});
$(document).ready(() => {
    $("#photoEdit").change(function () {
        const file = this.files[0];
        if (file) {
            let reader = new FileReader();
            reader.onload = function (event) {
                $("#photoEditPreview")
                    .attr("src", event.target.result);
            };
            reader.readAsDataURL(file);
        }
    });
});
/////////////////////////////////////////////////////////////

// change dinamicaly background color of status//
function changeStatusColor(){
    var collection = document.getElementsByClassName("badge");
    for(var i=0; i<collection.length;i++){
        if(collection.item(i).innerHTML === "ACHITAT"){
            collection.item(i).style.backgroundColor = "#006400";
        }else{
            collection.item(i).style.backgroundColor = "#8b0000";       
        }
    }
}
window.onload = function() {
    changeStatusColor();
  };
//////////////////////////////////////////////////////

