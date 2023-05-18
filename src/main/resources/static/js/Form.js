

setInterval(updateEventCount, 500);
setInterval(updateFinished, 1000);

function updateEventCount() {
    $.get("event-count").done(function(fragment) { 
        $("#eventCount").replaceWith(fragment); 
    });
}

function updateFinished() {
    $.get("finalizado").done(function(fragment) { 
        $("#finished").replaceWith(fragment);
    });
}