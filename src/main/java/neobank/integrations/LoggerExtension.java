package neobank.integrations;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Optional;

public class LoggerExtension implements BeforeEachCallback, TestWatcher {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void beforeEach(ExtensionContext context) {
        logger.info("'{}' - Test Started", context.getDisplayName());
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        logger.info(
                "'{}' - Test Disabled with reason:\n'{}':",
                context.getDisplayName(),
                reason.orElse("No reason"));
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        logger.info("'{}' - Test Successful", context.getDisplayName());
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        logger.warn(
                "'{}' - Test Aborted with message:\n'{}'",
                context.getDisplayName(),
                cause.getMessage());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        logger.error(
                "'{}' - Test Failed with message:\n'{}':",
                context.getDisplayName(),
                cause.getMessage());
    }
}
