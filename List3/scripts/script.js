function start_game(){
    images = ["hedgehog1.jpg","sad_hedgehog.jpg","sponge.jpg"]
    let start_button = document.getElementById("start_game")
    start_button.hidden=true;
    let  main_content = document.getElementById("main-content")
    
    image_name = images[Math.floor(Math.random() * images.length)]
    img= document.createElement('img')
    img.setAttribute('id','hedgehog_test')
    img.setAttribute('src',`../images/${image_name}`)
    main_content.appendChild(img)

    div_for_buttons=document.createElement("div")
    div_for_buttons.setAttribute('id','div_for_buttons')
    div_for_buttons.setAttribute("class","centered")
   
    div_for_buttons.innerHTML+= "czy to jest jeż?<br>"
    button_yes  = document.createElement("button")
    button_yes.setAttribute('id',"button_yes")
    button_yes.setAttribute("class","button-positive")
    button_yes.setAttribute("onclick","checkIfHedgehog()")
    button_yes.innerHTML="Yes"
    div_for_buttons.appendChild(button_yes)

    button_no  = document.createElement("button")
    button_no.setAttribute('id',"button_no")
    button_no.setAttribute("class","button-negative")
    button_no.setAttribute("onclick","checkIfNotHedgehog()")
    button_no.innerHTML="No"
    div_for_buttons.appendChild(button_no)
    main_content.appendChild(div_for_buttons)
    start_button.hidden=true
}

function checkIfHedgehog(){
    image = document.getElementById('hedgehog_test').src
    if(image.includes("hedgehog")){
        alert("zgadłeś")
    }
    else{
        alert("nie zgadłeś")
    }
    document.getElementById("button_yes").remove()
    document.getElementById("button_no").remove()
    document.getElementById("div_for_buttons").remove()
    document.getElementById('hedgehog_test').remove()
    document.getElementById("start_game").hidden=false
}
function checkIfNotHedgehog(){
    image = document.getElementById('hedgehog_test').src
    if(!image.includes("hedgehog")){
        alert("jesteś prawdziwym jeżoznawcą")
    }
    else{
        alert("nie zgadłeś")
    }
    document.getElementById("button_yes").remove()
    document.getElementById("button_no").remove()
    document.getElementById("div_for_buttons").remove()
    document.getElementById('hedgehog_test').remove()
    document.getElementById("start_game").hidden=false
}