<?php
/**
 * Plugin Name: Advertisement Viewer
 * Plugin URI: https://example.com/plugins/AdvertisementViewer/
 * Description: Views random advertisement before a post.
 * Version: 1.0
 * Requires at least: 5.0
 * Requires PHP: 7.2
 * Author: Aleksandra Serwicka
 * Author URI: https://darksource.pl/
 */

function av_admin_actions_register_menu(){
    add_options_page("Advertisement Viewer", "Advertisement Viewer", 'manage_options', "av", "av_admin_page");
}
   
add_action('admin_menu', 'av_admin_actions_register_menu');

function av_admin_page(){
    global $_POST;
    $advertisements = array();

    if(isset($_POST["submit"])){
        $advertisements = get_option('adv');
        array_push($advertisements, $_POST['adv']);
        echo '<div class="notice notice-success isdismissible"><p>Settings saved.</p></div>';
        echo count($advertisements);
        update_option('adv', $advertisements);
    }

?>
    <div class="wrap">
      <h1>Add new advertisement</h1>
        <form name="av_form" method="post">
            <input type="text" name="adv" size="100" value="Paste a HTML advertisement here"> 
            <p class="submit"><input type="submit" value="Submit" name="submit"></p>
        </form>
    </div>
<?php
} 

function av_view_advertisement($content){
    $adv_array = get_option('adv');
    $index = random_int(0, count($adv_array)-1);
    $advertisement = $adv_array[$index];
    return "<div class=\"adv\">$advertisement</div>"."<div style=\"color:blue;font-size:46px;\">$content</div>";
}

add_filter("the_content", "av_view_advertisement"); 

function av_register_styles(){
    wp_register_style('av_styles', plugins_url('\css\style.css', __FILE__));
    wp_enqueue_style('av_styles');
}
   
add_action('init', 'av_register_styles'); 
