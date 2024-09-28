package nazario.researchfrontiers.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
public interface ServerConnectionEvents {

    Event<ServerPlayConnectionEvents.Join> JOIN_EVENT = EventFactory.createArrayBacked(ServerPlayConnectionEvents.Join.class, (lis) -> (handler, sender, server) -> {
        ServerPlayerEntity player = handler.getPlayer();


    });

    Event<ServerPlayConnectionEvents.Disconnect> LEAVE_EVENT = EventFactory.createArrayBacked(ServerPlayConnectionEvents.Disconnect.class, (lis) -> (handler, server) -> {
        ServerPlayerEntity player = handler.getPlayer();

    });

    Event<ServerPlayConnectionEvents.Init> INIT_EVENT = EventFactory.createArrayBacked(ServerPlayConnectionEvents.Init.class, (lis) -> (handler, server) -> {
        ServerPlayerEntity player = handler.getPlayer();

    });
}
