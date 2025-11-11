package yuratexi.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Item_day extends Item {
    public Item_day(Settings settings){
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand){
        if(!world.isClient()){
            MinecraftServer server = world.getServer();
            if(server != null){

                for(int i=0;i<27;i++){
                    server.getCommandManager().parseAndExecute(
                            server.getCommandSource(),
                            "execute as @a at @a run execute if items entity @s inventory."+ i +" test-mod:day_item run item replace entity @s inventory."+i+" with test-mod:night_item"
                    );
                }

                for(int i=0;i<9;i++){
                    server.getCommandManager().parseAndExecute(
                            server.getCommandSource(),
                            "execute as @a at @a run execute if items entity @s hotbar."+i+" test-mod:day_item run item replace entity @s hotbar."+i+" with test-mod:night_item"
                    );
                }

                server.getCommandManager().parseAndExecute(
                        server.getCommandSource(),
                        "execute as @a at @a run execute if items entity @s weapon.offhand test-mod:day_item run item replace entity @s weapon.offhand with test-mod:night_item"
                );

                server.getCommandManager().parseAndExecute(
                        server.getCommandSource(),
                        "time set day"
                );
            }

        }
        return ActionResult.SUCCESS;
    }
}
