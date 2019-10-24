/**
* Post function condition to allow creation of sub task based on value
* selected in Select List multiple choice
* Video link: 
**/
def values = cfValues['My Multi List']*.value
if ( values.contains('Option 1') || values.contains('Option 2') || values.contains('Option 3')) {
    return true 
} else {
    return false
}